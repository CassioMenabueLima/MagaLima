package br.com.magalima.presenter;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Order;
import br.com.magalima.model.OrderModel;
import br.com.magalima.mvp.MVP;
import br.com.magalima.view.OrderIActivity;


public class OrderPresenter implements OrderIPresenter.OrderPresenterImpl {

    private OrderModel model;
    private OrderIActivity.OrderViewImpl view;
    private ArrayList<Order> orders = new ArrayList<>();

    public OrderPresenter(){
        model = new OrderModel(this);
    }

    @Override
    public void setView( OrderIActivity.OrderViewImpl view ){
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void updateListaRecycler(ArrayList<Order> m) {
        orders.clear();
        orders.addAll( m );
        view.updateListaRecycler();
    }

    @Override
    public void updateItemRecycler(Order m) {
        for(int i = 0; i < orders.size(); i++ ){
            if( orders.get(i).getId() == m.getId() ){
                orders.get(i).setEhFavorito( m.isEhFavorito() );
                view.updateItemRecycler( i );
                break;
            }
        }
    }

    @Override
    public ArrayList<Order> getOrder() {
        return orders;
    }

    @Override
    public String getIdUser() {
        return view.getIdUser();
    }

    @Override
    public void showToast(String mensagem) {

    }

    @Override
    public void showProgressBar(boolean status) {

    }


}
