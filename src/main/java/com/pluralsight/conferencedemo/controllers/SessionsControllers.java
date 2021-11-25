package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepositories;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
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
        return sessionRepositories.getOne(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session ){
        return sessionRepositories.saveAndFlush(session);
    }

    @RequestMapping( value = "{id}", method = RequestMethod.DELETE  )
    public void delete(@PathVariable Long id){
        sessionRepositories.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepositories.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepositories.saveAndFlush(existingSession);
    }
}
