package com.devguru.square;

import com.devguru.square.handler.SquareHandler;
import com.devguru.thrift.model.SquareService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan
public class ThriftSquareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThriftSquareServiceApplication.class, args);
    }

    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }

    @Bean
    public ServletRegistrationBean findSquare(TProtocolFactory protocolFactory, SquareHandler handler) {
        TServlet tServlet = new TServlet(new SquareService.Processor<SquareHandler>(handler), protocolFactory);

        return new ServletRegistrationBean(tServlet, "/find/square");
    }

}