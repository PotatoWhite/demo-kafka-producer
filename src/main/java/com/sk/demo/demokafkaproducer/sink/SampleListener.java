package com.sk.demo.demokafkaproducer.sink;


import com.sk.demo.demokafkaproducer.model.MessageDto;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(SampleSink.class)
@Component
public class SampleListener {

    @StreamListener(SampleSink.INPUT)
    public void handle(@Payload MessageDto aDto, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("P {}, Message {}", partition, aDto);
    }
}
