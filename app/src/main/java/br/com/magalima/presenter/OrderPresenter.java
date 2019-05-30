package br.com.magalima.presenter;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Order;
import br.com.magalima.model.OrderModel;
import br.com.magalima.mvp.MVP;
import br.com.magalima.view.CarIActivity;


public class OrderPresenter implements OrderIPresenter.CarPresenterImpl {

    private OrderModel model;
    private CarIActivity.CarViewImpl view;
    private ArrayList<Order> orders = new ArrayList<>();

    public OrderPresenter(){
        model = new OrderModel(this);
    }

    @Override
    public void setView( CarIActivity.CarViewImpl view ){
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void updateListaRecycler(ArrayList<Order> m) {

    }

    @Override
    public void updateItemRecycler(Order m) {

    }

    @Override
    public ArrayList<Order> getCar() {
        return null;
    }

    @Override
    public void retrieveMotos(Bundle savedInstanceState) {
        if( savedInstanceState != null ){
            orders = savedInstanceState.getParcelableArrayList( MVP.ViewImpl.MOTOS_KEY );
            return;
        }
        model.retrieveMotos();
    }

    @Override
    public void updateEhFavoritoMoto(Order order) {

    }

    @Override
    public void showToast(String mensagem) {

    }

    @Override
    public void showProgressBar(boolean status) {

    }


}
