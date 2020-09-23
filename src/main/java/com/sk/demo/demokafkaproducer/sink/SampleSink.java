package com.sk.demo.demokafkaproducer.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SampleSink {
    String INPUT = "consumer-stream";

    @Input(SampleSink.INPUT)
    SubscribableChannel consume();
}