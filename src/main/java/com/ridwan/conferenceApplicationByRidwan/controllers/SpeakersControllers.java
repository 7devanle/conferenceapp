package com.ridwan.conferenceApplicationByRidwan.controllers;

import com.ridwan.conferenceApplicationByRidwan.models.Speaker;
import com.ridwan.conferenceApplicationByRidwan.repositories.SpeakerRepositories;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersControllers {
    @Autowired
    private SpeakerRepositories speakerRepositories;

    public SpeakersControllers(SpeakerRepositories speakerRepositories) {
        this.speakerRepositories = speakerRepositories;
    }

    @GetMapping
    public List<Speaker> list(){
        return speakerRepositories.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker getSpeakeById(@PathVariable Long id){
        return speakerRepositories.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker ){
        return speakerRepositories.saveAndFlush(speaker);
    }


    @DeleteMapping( value = "{id}")
    public String delete(@PathVariable Long id){
        speakerRepositories.deleteById(id);
        return "speaker " + speakerRepositories.getById(id).getSpeaker_id() + " is deleted";

    }

    @PutMapping(value = "{id}")
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepositories.getById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepositories.saveAndFlush(existingSpeaker);
    }
}
