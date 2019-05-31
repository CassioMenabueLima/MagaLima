package br.com.magalima.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;



public class Order implements Parcelable {
    public static final String ID_KEY = "id";
    public static final String ID_METODO = "comanda";
    public static final String ID_ITEM_METODO = "itemcomanda";

    private int id;
    private Login login;
    private ArrayList<Product> products;


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

    }

    public Order() {
    }

    protected Order(Parcel in) {
        this.id = in.readInt();
        this.login = (Login) in.readValue(Login.class.getClassLoader());
        this.products = in.readArrayList(Product.class.getClassLoader());

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