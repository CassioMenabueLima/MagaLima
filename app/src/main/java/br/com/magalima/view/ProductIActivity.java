package br.com.magalima.view;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Moto;
import br.com.magalima.domain.Product;


public interface ProductIActivity {

    interface ProductViewImpl{
        String MOTOS_KEY = "products";

        public void showToast(String mensagem);
        public void showProgressBar(int visibilidade);
        public void updateListaRecycler();
        public void updateItemRecycler(int posicao);
        public void updateItemToCar(int posicao);
        public void removeItemToCar(int posicao);
        public void selectedItemOnCar(int posicao);
        public void nextActivity(Product product);
    }

}
