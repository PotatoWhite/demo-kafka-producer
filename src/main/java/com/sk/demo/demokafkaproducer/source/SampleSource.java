package com.sk.demo.demokafkaproducer.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SampleSource {
    String OUTPUT = "producer-stream";

    
    @Output(SampleSource.OUTPUT)
    MessageChannel produce();
}
