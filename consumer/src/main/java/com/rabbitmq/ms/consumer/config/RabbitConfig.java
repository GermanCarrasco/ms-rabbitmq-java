package com.rabbitmq.ms.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE = "catalog.exchange";
    public static final String ROUTING_KEY = "catalog.created";
    public static final String QUEUE = "catalogService";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE,true);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(ROUTING_KEY);
    }
}
