package com.devguru.squre.controller;

import com.devguru.squre.service.WebFluxSquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("webflux")
public class WebFluxSquareController {
    @Autowired
    private WebFluxSquareService squareService;

    @GetMapping("/flux/square/{number}")
    public Flux getSquareFlux(@PathVariable int number) {
        return this.squareService.findSquareFlux(number);
    }

    @GetMapping("/mono/square/{number}")
    public Mono getSquareMono(@PathVariable int number) {
        return this.squareService.findSquareMono(number);
    }
}
