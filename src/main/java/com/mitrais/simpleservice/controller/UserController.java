package com.mitrais.simpleservice.controller;

import com.mitrais.simpleservice.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Set<User> users = Arrays.asList(
            new User(1L,"Tiara","Dewi"),
            new User(2L,"Dona","Agnes")
    ).stream().collect(Collectors.toSet());

    @GetMapping("/find-one")
    public User findOne(){
        return users.stream().filter(user->user.getId().equals(1L)).findAny().get();
    }
}
