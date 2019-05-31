package br.com.magalima.presenter;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;


import br.com.magalima.domain.Product;
import br.com.magalima.model.OrderModel;

import br.com.magalima.view.OrderActivity;
import br.com.magalima.view.OrderIActivity;


public class OrderPresenter implements OrderIPresenter.OrderPresenterImpl {

    private OrderModel model;
    private OrderIActivity.OrderViewImpl view;
    private ArrayList<Product> orders = new ArrayList<>();

    public OrderPresenter() {
        model = new OrderModel(this);
    }

    @Override
    public void setView(OrderIActivity.OrderViewImpl view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void updateListaRecycler(ArrayList<Product> m) {
        orders.clear();
        orders.addAll(m);
        view.updateListaRecycler();
    }


    @Override
    public ArrayList<Product> getOrder() {

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

    @Override
    public void retrieveOrder(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            orders = savedInstanceState.getParcelableArrayList(OrderActivity.KEY);

            return;
        }
        model.getOrders();
    }
}
