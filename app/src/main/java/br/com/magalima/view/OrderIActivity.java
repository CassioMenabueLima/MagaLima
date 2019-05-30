package br.com.magalima.view;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Moto;
import br.com.magalima.domain.Product;


public interface OrderIActivity {


    interface OrderViewImpl {
        String KEY = "order";

        public void showToast(String mensagem);
        public void showProgressBar(int visibilidade);
        public void updateListaRecycler();
        public void updateItemRecycler(int posicao);
        public String getIdUser();

    }

}
