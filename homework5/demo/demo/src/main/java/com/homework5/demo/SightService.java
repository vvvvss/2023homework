package com.homework5.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightService {
    @Autowired
    private SightRepository repository;

    public List<Sight> getSights(String name){
        return repository.findByZoneLike(name);
    }

    public Sight createSight(Sight request){
        Sight sight = new Sight(
                request.getSightName(),
                request.getZone(),
                request.getCategory(),
                request.getPhotoURL(),
                request.getDescription(),
                request.getAddress()
        );
        return repository.insert(sight);
    }
}
