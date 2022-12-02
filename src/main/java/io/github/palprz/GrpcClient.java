package io.github.palprz;

import io.github.palprz.autogenerated.RequestMsg;
import io.github.palprz.autogenerated.ResponseMsg;
import io.github.palprz.autogenerated.ResultServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        ResultServiceGrpc.ResultServiceBlockingStub stub
                = ResultServiceGrpc.newBlockingStub(channel);

        ResponseMsg helloResponse = stub.transfer(RequestMsg.newBuilder()
                .setFirstName("John")
                .setLastName("Smith")
                .build());

        System.out.println("From GrpcClient: " + helloResponse);

        channel.shutdown();
    }

}
