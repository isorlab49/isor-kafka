package com.isor.example.kafka.cache.consumer;

import com.isor.example.kafka.cache.model.DictionaryItem;
import com.isor.example.kafka.cache.repositories.DictionaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    DictionaryRepository repository;

    @KafkaListener(topics = "${watch.topics}")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        DictionaryItem newItem = new DictionaryItem(consumerRecord.key(), consumerRecord.value());
        log.info("Saving payload {} to Redis {}", consumerRecord.toString(), newItem);
        log.info(consumerRecord.key());
        log.info(consumerRecord.value());
        repository.save(newItem);
    }
}
