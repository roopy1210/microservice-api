package com.devguru.square.service;

import org.springframework.stereotype.Service;

@Service
public class RestSquareServiceImpl implements RestSquareService {
    @Override
    public int getSquare(int number) {
        return number * number;
    }
}
