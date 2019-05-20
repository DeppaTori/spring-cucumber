package com.mitrais.simpleservice.controller;

import com.mitrais.simpleservice.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("/{id}")
    public User allUser(@PathVariable("id") int id){

        User user = new User(id==1?"Tiara":"Dona","Dewi");
        return user;
    }
}
