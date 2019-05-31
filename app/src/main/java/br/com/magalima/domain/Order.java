package br.com.magalima.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;



public class Order implements Parcelable {
    public static final String ID_KEY = "id";


    private int id;
    private Login login;
    private ArrayList<Product> products;
    private boolean ehFavorito;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }





    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeValue(this.login);
        dest.writeList(this.products);
        dest.writeByte(this.ehFavorito ? (byte) 1 : (byte) 0);
    }

    public Order() {
    }

    protected Order(Parcel in) {
        this.id = in.readInt();
        this.login = (Login) in.readValue(Login.class.getClassLoader());
        this.products = in.readArrayList(Product.class.getClassLoader());
        this.ehFavorito = in.readByte() != 0;
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}