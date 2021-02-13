package com.devguru.api.controller;

import com.devguru.api.service.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("thrift")
public class ThriftAPIController {

    @Autowired
    private ThriftService service;

    @GetMapping("/square/{number}")
    public Object getSquare(@PathVariable int number) throws TException {
        return this.service.findSquare(number);
    }

}
