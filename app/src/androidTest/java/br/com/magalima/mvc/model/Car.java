package br.com.magalima.mvc.model;

import java.util.ArrayList;

public class Car {
private String id_car;
private String id_user;
private double qtd;
private ArrayList<Product> products;

    public Car(String id_car, String id_user, double qtd, ArrayList<Product> products) {
        this.id_car = id_car;
        this.id_user = id_user;
        this.qtd = qtd;
        this.products = products;
    }
}
