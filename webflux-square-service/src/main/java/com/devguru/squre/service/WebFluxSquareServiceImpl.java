package com.devguru.squre.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebFluxSquareServiceImpl implements WebFluxSquareService {
    @Override
    public Flux findSquareFlux(int number) {
        return Flux.just(number * number);
    }

    @Override
    public Mono findSquareMono(int number) {
        return Mono.just(number * number);
    }
}
