package com.example.security.demo.controller;

import com.example.security.demo.dto.AnimalDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("animal")
public class TestController {

    @PostMapping
    public ResponseEntity<AnimalDto> add(@RequestBody AnimalDto animal) {
        System.out.println(animal);
        final URI redirect = URI.create("any");
        return created(redirect).body(animal);
    }

    @GetMapping
    public ResponseEntity<AnimalDto> get(@RequestParam String name) {
        System.out.println(name);
        return ok(new AnimalDto(name, "dog"));
    }
}
