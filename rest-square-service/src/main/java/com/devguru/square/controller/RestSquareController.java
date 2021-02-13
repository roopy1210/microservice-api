package com.devguru.square.controller;

import com.devguru.square.service.RestSquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class RestSquareController {

    @Autowired
    private RestSquareService squareService;

    @GetMapping("/square/{number}")
    public int getSquare(@PathVariable int number) {
        return this.squareService.getSquare(number);
    }

}
