package com.ridwan.conferenceApplicationByRidwan.controllers;

import com.ridwan.conferenceApplicationByRidwan.models.Session;
import com.ridwan.conferenceApplicationByRidwan.repositories.SessionRepositories;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsControllers {
    @Autowired
    private SessionRepositories sessionRepositories;
    public SessionsControllers(SessionRepositories sessionRepositories) {
        this.sessionRepositories = sessionRepositories;
    }

    @GetMapping
    public List<Session> list(){
        return sessionRepositories.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        if (sessionRepositories.existsById(id)){
            return sessionRepositories.getById(id);
        }
        return null;
    }
    @PostMapping
    public Session create(@RequestBody final Session session ){
        return sessionRepositories.saveAndFlush(session);
    }

    @DeleteMapping( value = "{id}")
    public String delete(@PathVariable Long id){
        sessionRepositories.deleteById(id);
        return "session " + sessionRepositories.getById(id).getSession_id() + "is deleted";
    }

    @PutMapping(value = "{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepositories.getById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepositories.saveAndFlush(existingSession);
    }
}
