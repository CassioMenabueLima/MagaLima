package br.com.magalima.presenter;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Order;
import br.com.magalima.view.CarIActivity;


public interface OrderIPresenter {


    interface CarPresenterImpl{
        public void retrieveMotos(Bundle savedInstanceState);
        public void updateEhFavoritoMoto(Order order);
        public void showToast(String mensagem);
        public void showProgressBar(boolean status);
        public void setView(CarIActivity.CarViewImpl view);
        public Context getContext();
        public void updateListaRecycler(ArrayList<Order> m);
        public void updateItemRecycler(Order m);
        public ArrayList<Order> getCar();
    }


}
