package com.sk.demo.demokafkaproducer.source;

import com.sk.demo.demokafkaproducer.model.MessageDto;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(SampleSource.class)
public class SampleProducer {
    private SampleSource source;

    public SampleProducer(SampleSource source) {
        this.source = source;
    }

    public Boolean sendMessage(final MessageDto message) {
        return source.produce().send(
                MessageBuilder
                    .withPayload(message)
                    .setHeader("partitionKey", message.getKey())
                    .build()
                    );
    }

}