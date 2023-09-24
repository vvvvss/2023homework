package com.homework5.demo;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class KeelungSightsCrawler implements ApplicationRunner {


    private final SightRepository sightRepository;
    public static ArrayList<Sight> sightList;
    public KeelungSightsCrawler(SightRepository sightRepository) throws IOException {
        this.sightRepository = sightRepository;
        sightList = new ArrayList<>();
        String blogUrl = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";
        Document doc = Jsoup.connect(blogUrl).get();
        Elements contents = doc.select("div.box > ul li a");
        for(Element content : contents){
            Document docChild = Jsoup.connect(content.attr("abs:href")).get();
            sightList.add(new Sight(
                    docChild.select(".h1").text(),
                    docChild.select("[class = bc_last] > a").text(),
                    docChild.select("[property = rdfs:label").text(),
                    docChild.select("[class = gpic] > img").attr("data-src"),
                    docChild.select("#point_area > [itemprop = description]").attr("content"),
                    docChild.select("[title = Map]").attr("href")
                    )
            );
        }
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        sightRepository.deleteAll();
        sightRepository.saveAll(sightList);
    }
}