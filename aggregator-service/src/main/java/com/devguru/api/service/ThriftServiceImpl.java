package com.devguru.api.service;

import com.devguru.thrift.model.SquareResponse;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ThriftServiceImpl implements  ThriftService {

    @Autowired
    private ThriftClient thriftClient;

    @Override
    public Map<Integer, Integer> findSquare(int number) throws TException {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= number ; i++) {
            SquareResponse response = thriftClient.findSquare(i);
            map.put(i,response.getResult());
        }
        return map;
    }
}
