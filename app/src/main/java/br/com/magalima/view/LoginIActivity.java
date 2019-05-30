package br.com.magalima.view;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Login;
import br.com.magalima.domain.Moto;


public interface LoginIActivity {

    interface LoginViewImpl{
        String KEY = "login";

        public void showToast(String mensagem);
        public void showProgressBar(int visibilidade);
        public void nextActivity(Login login);
        public String getUserName();
        public String getPassword();
    }

}
