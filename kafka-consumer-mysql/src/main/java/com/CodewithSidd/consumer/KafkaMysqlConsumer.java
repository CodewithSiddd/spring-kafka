package com.CodewithSidd.consumer;

import com.CodewithSidd.consumer.entity.WikiMediaData;
import com.CodewithSidd.consumer.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMysqlConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMysqlConsumer.class);
    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaMysqlConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(
            topics = "Wikimedia-recent-changes",
            groupId = "group"
    )
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Message which is received -> %s", eventMessage));
        WikiMediaData data = new WikiMediaData();
        data.setWikiMediaEventData(eventMessage);
        wikimediaDataRepository.save(data);
    }

}
