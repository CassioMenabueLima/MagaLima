package br.com.magalima.presenter;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Login;
import br.com.magalima.domain.Moto;
import br.com.magalima.view.LoginIActivity;


public interface LoginIPresenter {


    interface LoginPresenterImpl{

        public void showToast(String mensagem);
        public void showProgressBar(boolean status);
        public void setView(LoginIActivity.LoginViewImpl view);
        public Context getContext();
        public void setLogin( Login login);
        public void sendLogin(String userName, String password);
        public boolean valideFields();
        //public void validateLogin( Login login);
    }



}
