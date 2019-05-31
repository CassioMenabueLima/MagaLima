package br.com.magalima.domain;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.magalima.R;


public class Login implements Parcelable {
    public static final String ID_USERNAME = "username";
    public static final String ID_PASSWORD = "password";

    private String id;
    private String userName;
    private String email;
    private String name;
    private boolean ehFavorito;

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.userName);
        dest.writeString(this.email);
        dest.writeString(this.name);
        dest.writeByte(this.ehFavorito ? (byte) 1 : (byte) 0);
    }

    public Login() {
    }

    protected Login(Parcel in) {
        this.id = in.readString();
        this.userName = in.readString();
        this.email = in.readString();
        this.name = in.readString();
        this.ehFavorito = in.readByte() != 0;
    }

    public static final Creator<Login> CREATOR = new Creator<Login>() {
        @Override
        public Login createFromParcel(Parcel source) {
            return new Login(source);
        }

        @Override
        public Login[] newArray(int size) {
            return new Login[size];
        }
    };
}