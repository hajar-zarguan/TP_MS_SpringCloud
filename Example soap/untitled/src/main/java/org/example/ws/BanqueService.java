package org.example.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;
@WebService(serviceName = "BanqueWS")
public class BanqueService {

    @WebMethod(operationName = "Conversion")
    public double Conversion (@WebParam  double mt){
        return  mt*10.5;
    }

    @WebMethod
    public  Compte getCompte(@WebParam int code){
        return  new Compte(code, Math.random()*29 , new Date());
    }

    @WebMethod
    public List<Compte> listCompte(){
        return  List.of(
                new Compte(1, Math.random()*6865, new Date()),
                new Compte(2, Math.random()*6865, new Date()),
                new Compte(3, Math.random()*6865, new Date())
                );
    }
}

