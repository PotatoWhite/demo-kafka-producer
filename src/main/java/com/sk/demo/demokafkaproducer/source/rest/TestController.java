package com.sk.demo.demokafkaproducer.source.rest;

import com.sk.demo.demokafkaproducer.model.MessageDto;
import com.sk.demo.demokafkaproducer.source.SampleProducer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final SampleProducer sampleProducer;

    public TestController(SampleProducer sampleProducer) {
        this.sampleProducer = sampleProducer;
    }

    @PostMapping("/samples")
    public ResponseEntity createAMessage(@RequestBody MessageDto aDto) {
        Boolean result = sampleProducer.sendMessage(aDto);

        if (Boolean.TRUE.equals(result))
            return ResponseEntity.ok().build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
