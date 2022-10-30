package org.example;
import jakarta.xml.ws.Endpoint;
import org.example.ws.BanqueService;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Endpoint.publish("http://0.0.0.0:9191/",new BanqueService());
        System.out.println("service");
    }
}