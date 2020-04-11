package com.demo.app.services;


import com.demo.app.Configuration.RabbitMQ.RabbitMQSender;
import com.demo.app.entities.Website;
import com.demo.app.repositories.WebSiteRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSiteService {

    @Autowired
    private WebSiteRepository webSiteRepository;

    @Autowired
    RabbitMQSender rabbitMQSender;

    public List<Website> getAllWebSites(){

        rabbitMQSender.send(new Website("url","title","desc"));
        return webSiteRepository.findAll();
    }


    @RabbitListener(queues = "${rabbitmq.queue}")
    public void recievedMessage(Object o) {
        System.out.println("Recieved Message From RabbitMQ: " + o);
    }
}
