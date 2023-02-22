package br.com.myfirstblog.blog.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.myfirstblog.blog.models.entities.User;
import br.com.myfirstblog.blog.models.services.UserServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createNewUser(@Valid User user){
        User newUser = userServices.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}

