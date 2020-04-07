package com.demo.app.Configuration.RabbitMQ;

import com.demo.app.entities.Website;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public void send(Website website) {
        rabbitTemplate.convertAndSend(exchange, routingkey, website);
        System.out.println("Send msg = " + website);

    }
}