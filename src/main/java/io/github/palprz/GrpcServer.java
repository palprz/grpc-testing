package io.github.palprz;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Starting server...");

        Server server = ServerBuilder
                .forPort(8080)
                .addService(new ResultServiceImpl()).build();

        server.start();

        // keep running server
        server.awaitTermination();
    }

}
