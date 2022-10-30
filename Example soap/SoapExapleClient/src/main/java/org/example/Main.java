package org.example;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
       BanqueService stub = new BanqueWS().getBanqueServicePort();
       System.out.println(stub.conversion(7878));


    }
}