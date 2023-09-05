package com.homework5.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SightController {
    @Autowired
    private SightService sightService;

    @GetMapping("/sight")
    public ResponseEntity<List<Sight>> getSights(
            @RequestParam(value = "zone", defaultValue = "")String name){
        List<Sight> sights = sightService.getSights(name);
        return ResponseEntity.ok(sights);
    }
}
