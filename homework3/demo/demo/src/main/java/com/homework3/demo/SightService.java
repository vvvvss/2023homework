package com.homework3.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightService {
    @Autowired
    private MockSightDAO sightDAO;

    public List<Sight> getSights(String name){
        return sightDAO.find(name);
    }
}
