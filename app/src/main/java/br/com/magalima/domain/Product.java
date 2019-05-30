package br.com.magalima.domain;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.magalima.R;


public class Product implements Parcelable {
    public static final String ID_KEY = "id";
    public static final String EH_FAVORITO_KEY = "eh-favorito";

    private String id;
    private String descricao;
    private String valor;
    private String informacoes;
    private boolean ehFavorito;


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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
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
        dest.writeString(this.id);
        dest.writeString(this.descricao);
        dest.writeString(this.valor);
        dest.writeString(this.informacoes);
        dest.writeByte(this.ehFavorito ? (byte) 1 : (byte) 0);
    }

    public Product() {
    }

    protected Product(Parcel in) {
        this.id = in.readString();
        this.descricao = in.readString();
        this.valor = in.readString();
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