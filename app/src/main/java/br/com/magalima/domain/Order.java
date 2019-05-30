package br.com.magalima.domain;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.magalima.R;


public class Order implements Parcelable {
    public static final String ID_KEY = "id";
    public static final String EH_FAVORITO_KEY = "eh-favorito";

    private int id;
    private String modelo;
    private String marca;
    private String imagem;
    private boolean ehFavorito;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public boolean isEhFavorito() {
        return ehFavorito;
    }

    public void setEhFavorito(boolean ehFavorito) {
        this.ehFavorito = ehFavorito;
    }

    public int getEhFavoritoIcone(){
        if( isEhFavorito() ){
            return R.drawable.ic_arrow_r;
        }
        return R.drawable.ic_launcher_background;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.modelo);
        dest.writeString(this.marca);
        dest.writeString(this.imagem);
        dest.writeByte(this.ehFavorito ? (byte) 1 : (byte) 0);
    }

    public Order() {
    }

    protected Order(Parcel in) {
        this.id = in.readInt();
        this.modelo = in.readString();
        this.marca = in.readString();
        this.imagem = in.readString();
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