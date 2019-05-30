package br.com.magalima.presenter;

import android.content.Context;

import java.util.ArrayList;

import br.com.magalima.domain.Order;
import br.com.magalima.domain.Product;
import br.com.magalima.view.OrderIActivity;


public interface OrderIPresenter {


    interface OrderPresenterImpl {

        public void showToast(String mensagem);
        public void showProgressBar(boolean status);
        public void setView(OrderIActivity.OrderViewImpl view);
        public Context getContext();
        public void updateListaRecycler(ArrayList<Order> m);
        public void updateItemRecycler(Order m);
        public ArrayList<Order> getOrder();
        public  String getIdUser();

    }


}
