package com.devguru.api.controller;

import com.devguru.api.service.WebClientService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("webclient")
public class WebClientAPIController {

    @Autowired
    private WebClientService service;

    @GetMapping("/flux/square/{number}")
    public Map<Integer, Integer> getSquareFlux(@PathVariable int number) throws TException {
        return this.service.getSquareFlux(number);
    }

    @GetMapping("/mono/square/{number}")
    public Map<Integer, Integer> getSquareMono(@PathVariable int number) throws TException {
        return this.service.getSquareMono(number);
    }

}
