package com.homework5.demo;

import jakarta.annotation.PostConstruct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class KeelungSightsCrawler {

    @Autowired
    private  SightRepository sightRepository;
    public static ArrayList<Sight> sightList;
    public KeelungSightsCrawler() throws IOException {
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

    @PostConstruct
    public void runCrawlerAndSaveToMongoDB(){
        sightRepository.deleteAll();
        sightRepository.saveAll(sightList);
    }
}