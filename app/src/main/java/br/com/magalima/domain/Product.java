package br.com.magalima.domain;

import android.os.Parcel;
import android.os.Parcelable;



public class Product implements Parcelable {


    private String id;
    private String descricao;
    private double valor;
    private double quantity;
    private double total;
    private String informacoes;
    private boolean ehFavorito;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }






    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.descricao);
        dest.writeDouble(this.valor);
        dest.writeDouble(this.quantity);
        dest.writeDouble(this.total);
        dest.writeString(this.informacoes);
        dest.writeByte(this.ehFavorito ? (byte) 1 : (byte) 0);
    }

    public Product() {
    }

    protected Product(Parcel in) {
        this.id = in.readString();
        this.descricao = in.readString();
        this.valor = in.readDouble();
        this.quantity = in.readDouble();
        this.total = in.readDouble();
        this.informacoes = in.readString();
        this.ehFavorito = in.readByte() != 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}