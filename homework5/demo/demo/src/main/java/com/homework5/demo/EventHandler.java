package com.homework5.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {
    @Autowired
    private KeelungSightsCrawler keelungSightsCrawler;

    @EventListener(ContextStartedEvent.class)
    public void handleContextStartEvent(ContextStartedEvent e){
        keelungSightsCrawler.runCrawlerAndSaveToMongoDB();
    }
}
