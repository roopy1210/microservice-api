package com.devguru.squre.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WebFluxSquareService {
    public Flux findSquareFlux(int number);

    public Mono findSquareMono(int number);
}
