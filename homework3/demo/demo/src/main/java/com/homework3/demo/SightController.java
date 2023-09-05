package com.homework3.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
