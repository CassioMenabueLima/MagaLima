package br.com.magalima.presenter;

import android.content.Context;

import br.com.magalima.domain.Login;
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

    }



}
