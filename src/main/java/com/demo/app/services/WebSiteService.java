package com.demo.app.services;


import com.demo.app.Configuration.RabbitMQ.RabbitMQSender;
import com.demo.app.entities.Website;
import com.demo.app.repositories.WebSiteRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class WebSiteService {

    @Autowired
    private WebSiteRepository webSiteRepository;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Transactional
    public Website sendWebSite(){
        Website website=new Website("www.google.com","Google","Search engine ");
        website=webSiteRepository.save(website);
        rabbitMQSender.send(website);
        return website;
    }


    @RabbitListener(queues = "${rabbitmq.queue}")
    public void recievedMessage(Object o) {
        System.out.println("Recieved Message From RabbitMQ: " + o);
    }
}
