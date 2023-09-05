package com.homework3.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.homework3.demo.KeelungSightsCrawler.sightList;

@Repository
public class MockSightDAO {
    private ArrayList<Sight> sightDB = new ArrayList<>();

    @PostConstruct
    private void initDB(){
        sightDB = sightList;
    }

    public List<Sight> find(String name){
        return sightDB.stream()
                .filter(p -> p.getZone().contains(name))
                .collect(Collectors.toList());
    }
}
