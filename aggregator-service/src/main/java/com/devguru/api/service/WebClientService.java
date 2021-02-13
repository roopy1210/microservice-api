package com.devguru.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebClientService {

    public Map<Integer, Integer>  getSquareFlux(int number) {

        Map<Integer, Integer> map = new HashMap<>();

        WebClient webClient = WebClient.create("http://localhost:6565");

        for (int i = 0; i <= number; i++) {
                map.put(i, webClient.get()
                                    .uri("/webflux/flux/square/" + i)
                                    .retrieve()
                                    .bodyToFlux(Integer.class)
                                    .blockLast());
        }

        return map;

    }

    public Map<Integer, Integer>  getSquareMono(int number) {

        Map<Integer, Integer> map = new HashMap<>();

        WebClient webClient = WebClient.create("http://localhost:6565");

        for (int i = 0; i <= number; i++) {
            map.put(i, webClient.get()
                    .uri("/webflux/mono/square/" + i)
                    .retrieve()
                    .bodyToMono(Integer.class)
                    .block());
        }

        return map;

    }

}
