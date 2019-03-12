package com.company.server;

import com.company.common.Product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProductServer {

    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) throws Exception {


        //Listening
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            System.out.println("Waiting for client...");
            //Read\Write
            Socket socket = serverSocket.accept();

            System.out.println("Client connected");


            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Product product = (Product) inputStream.readObject();

            /**
             * class ProtocolRequest
             *
             *  String operationType  delete/save/get/get MY products     enum/string
             *  Product payload
             *  String credentials (login) -> username
             *
             */
            //Payload -> Person


            System.out.println("Read information from client");

            product.setId(products.size() + 1);

            products.add(product);


            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(products);
            System.out.println("Returning response...");

            outputStream.close();
            inputStream.close();
            socket.close();

            System.out.println("Request finished");
        }
    }





    void method() {


        String response;

        try {
            //some operation

            response = "successful";
        } catch (Exception e) {
            response = "failed";
        }

        //sending response
    }











}
