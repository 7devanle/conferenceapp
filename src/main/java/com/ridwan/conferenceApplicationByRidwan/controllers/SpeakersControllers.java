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
    public Speaker get(@PathVariable Long id){
        return speakerRepositories.getOne(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker ){
        return speakerRepositories.saveAndFlush(speaker);
    }


    @RequestMapping( value = "{id}", method = RequestMethod.DELETE  )
    public void delete(@PathVariable Long id){
        speakerRepositories.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepositories.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "session_id");
        return speakerRepositories.saveAndFlush(existingSpeaker);
    }
}
