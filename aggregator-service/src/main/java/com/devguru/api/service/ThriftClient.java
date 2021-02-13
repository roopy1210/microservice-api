package com.devguru.api.service;

import com.devguru.thrift.model.SquareService;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;
import org.springframework.stereotype.Component;

@Component
public class ThriftClient extends SquareService.Client {

    public ThriftClient(TProtocolFactory tProtocolFactory) throws TTransportException {
        super(tProtocolFactory.getProtocol(new THttpClient("http://localhost:8585/find/square")));
    }
}
