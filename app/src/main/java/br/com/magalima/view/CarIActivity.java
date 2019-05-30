package br.com.magalima.view;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Moto;


public interface CarIActivity {


    interface CarViewImpl{
        String MOTOS_KEY = "motos";

        public void showToast(String mensagem);
        public void showProgressBar(int visibilidade);
        public void updateListaRecycler();
        public void updateItemRecycler(int posicao);
    }

}
