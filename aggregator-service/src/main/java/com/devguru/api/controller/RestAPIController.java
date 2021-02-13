package com.devguru.api.controller;

import com.devguru.api.service.RestService;
import com.devguru.api.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class RestAPIController {

    @Autowired
    private RestService service;

    @GetMapping("/square/{number}")
    public Object getResponseUnary(@PathVariable int number){
        return this.service.getUnaryResponse(number);
    }

}
