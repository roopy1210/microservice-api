package com.devguru.api.service;

import com.devguru.model.SquareRequest;
import com.devguru.model.SquareResponse;
import com.devguru.model.SquareRpcGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GrpcService {

    @GrpcClient("square")
    private SquareRpcGrpc.SquareRpcBlockingStub blockingStub;

    @GrpcClient("square")
    private SquareRpcGrpc.SquareRpcStub asyncStub;

    public Object getSquareResponseUnary(int number){
        return IntStream.rangeClosed(1, number)
                .mapToObj(i -> SquareRequest.newBuilder().setNumber(i).build())
                .map(this.blockingStub::findSquareUnary)
                .collect(Collectors.toMap(
                        SquareResponse::getNumber,
                        SquareResponse::getResult
                ));
    }

    public Object getSquareResponseStream(int number){
        CompletableFuture<Map<Integer, Integer>> completableFuture = new CompletableFuture<>();
        OutputStreamingResponse outputStreamingResponse = new OutputStreamingResponse(
                new HashMap<>(),
                completableFuture
        );
        StreamObserver<SquareRequest> squareBiStream = this.asyncStub.findSquareBiStream(outputStreamingResponse);
        IntStream.rangeClosed(1, number)
                .mapToObj(i -> SquareRequest.newBuilder().setNumber(i).build())
                .forEach(squareBiStream::onNext);
        squareBiStream.onCompleted();
        return completableFuture;
    }

}