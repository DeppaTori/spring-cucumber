package com.mitrais.simpleservice.controller;

import com.mitrais.simpleservice.model.Bag;
import com.mitrais.simpleservice.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/things")
public class ThingsController {

    private final Bag bag = new Bag();

    @GetMapping
    public Bag getBag() {
        return bag;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addThing(@RequestBody final String something) {
        bag.add(something);
    }

    @DeleteMapping
    public void removeEverything() {
        bag.removeEverything();
    }
}
