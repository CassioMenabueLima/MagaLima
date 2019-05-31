package br.com.magalima.presenter;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

import br.com.magalima.domain.Login;
import br.com.magalima.model.LoginModel;

import br.com.magalima.view.LoginIActivity;


public class LoginPresenter implements LoginIPresenter.LoginPresenterImpl {

    private LoginModel model;
    private LoginIActivity.LoginViewImpl view;


    public LoginPresenter(){
        model = new LoginModel(this);
    }


    @Override
    public void showToast(String mensagem) {
        view.showToast( mensagem );
    }

    @Override
    public void showProgressBar(boolean status) {
        int visibilidade = status ? View.VISIBLE : View.GONE;
        view.showProgressBar( visibilidade );
    }

    @Override
    public void setView(LoginIActivity.LoginViewImpl view) {
        this.view = view;
    }



    @Override
    public Context getContext() {
        return (Context) view;
    }



    @Override
    public void setLogin(Login login) {

        if(login !=null){
            view.showToast( "Login efetuado com sucesso" );
            view.nextActivity( login);
        }else{
            view.showToast( "Login Nao efetuado " );
        }


    }

    @Override
    public void sendLogin(String userName, String password) {
        model.sendLogin(view.getUserName(),view.getPassword());
    }

    @Override
    public boolean valideFields() {

        return view.getUserName().isEmpty() || view.getPassword().isEmpty();
    }
}
