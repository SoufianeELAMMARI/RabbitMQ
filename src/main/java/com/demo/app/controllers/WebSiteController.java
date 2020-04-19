package com.demo.app.controllers;

import com.demo.app.entities.Website;
import com.demo.app.services.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebSiteController {

    @Autowired
    WebSiteService webSiteService;

    @GetMapping("/send")
    public Website sendWebSite(){
        return webSiteService.sendWebSite();
    }
}
