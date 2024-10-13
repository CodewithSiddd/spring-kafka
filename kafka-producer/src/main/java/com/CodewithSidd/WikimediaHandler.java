package com.CodewithSidd;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaHandler implements BackgroundEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaHandler.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public WikimediaHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    //Whenever theres any changes in wikimedia or new data is published on wikimedia then,
    //this class WikimediaHandler will get triggered and within this class this onMessage method
    //will send new data to topic from kafkatemplates send method.
    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info((String.format("event data -> %s", messageEvent.getData())));
        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }

}
