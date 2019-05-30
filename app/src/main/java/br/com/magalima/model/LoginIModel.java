package br.com.magalima.model;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Moto;


public interface LoginIModel {
    interface LoginModelImpl{
        public void retrieveLogon();
        public void sendLogin(String userName, String password);

    }



}
