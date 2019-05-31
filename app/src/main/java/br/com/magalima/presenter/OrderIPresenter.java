package br.com.magalima.presenter;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;


import br.com.magalima.domain.Product;
import br.com.magalima.view.OrderIActivity;


public interface OrderIPresenter {


    interface OrderPresenterImpl {
        public void retrieveOrder(Bundle savedInstanceState);
        public void showToast(String mensagem);
        public void showProgressBar(boolean status);
        public void setView(OrderIActivity.OrderViewImpl view);
        public Context getContext();
        public void updateListaRecycler(ArrayList<Product> m);

        public ArrayList<Product> getOrder();
        public  String getIdUser();


    }


}
