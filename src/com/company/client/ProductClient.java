package com.company.client;

import com.company.common.Product;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ProductClient {

    public static void main(String[] args) throws Exception {

        //Console input
        Product product = new Product("Brother Printer", 1000., "SOLD");



        Socket socket = new Socket("localhost", 8080);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(product);

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        //ProtocolResponse
        List<Product> products = (List<Product>) objectInputStream.readObject();

        objectOutputStream.close();
        objectInputStream.close();
        socket.close();

        products.forEach(x -> {
                    String productPrint = String.format("Id: %s | Product: %s | Price: %s | Status: %s",
                            x.getId(),
                            x.getProductName(),
                            x.getPrice(),
                            x.getStatus());
                    System.out.println(productPrint);
                }
            );


        System.out.println("Product saved");
    }
}
