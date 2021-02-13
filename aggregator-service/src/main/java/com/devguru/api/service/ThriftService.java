package com.devguru.api.service;

import com.devguru.thrift.model.SquareResponse;
import org.apache.thrift.TException;

import java.util.Map;

public interface ThriftService {
    public Map<Integer, Integer> findSquare(int number) throws TException;
}
