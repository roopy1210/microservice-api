package com.devguru.square.handler;

import com.devguru.thrift.model.SquareResponse;
import com.devguru.thrift.model.SquareService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

@Component
public class SquareHandler implements SquareService.Iface {

    @Override
    public SquareResponse findSquare(int number) throws TException {
        return new SquareResponse(number, number * number);
    }

}
