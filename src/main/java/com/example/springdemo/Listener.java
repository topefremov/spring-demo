package com.example.springdemo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Component
public class Listener {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final JdbcTemplate jdbcTemplate;

    public Listener(KafkaTemplate<String, String> kafkaTemplate, JdbcTemplate jdbcTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

//    @KafkaListener(id = "group1", topics = "topic1")
//    @Transactional("dstm")
//    public void listen(String in) throws ExecutionException, InterruptedException {
//        this.kafkaTemplate.send("topic2", in.toUpperCase()).get();
//        this.jdbcTemplate.update("insert into t1 (id, data) values (?, ?)", UUID.randomUUID().toString(), in);
//        throw new IllegalStateException("test!!");
//    }

    @KafkaListener(id = "group2", topics = "topic2")
    @Transactional("dstm")
    public void listen1(String in) {
        System.out.println(in);
    }
}
