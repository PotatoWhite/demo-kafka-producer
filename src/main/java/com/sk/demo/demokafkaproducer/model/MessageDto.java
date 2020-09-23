package com.sk.demo.demokafkaproducer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageDto{
    private String key;
    private String message;
}