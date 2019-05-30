package br.com.magalima.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import br.com.magalima.domain.Moto;
import br.com.magalima.domain.Product;
import br.com.magalima.model.ProductIModel;
import br.com.magalima.model.ProductModel;
import br.com.magalima.mvp.MVP;
import br.com.magalima.view.ProductActivity;
import br.com.magalima.view.ProductIActivity;


public class ProductPresenter implements ProductIPresenter.ProductPresenterImpl {

    private ProductIModel.ProductModelImpl model;
    private ProductIActivity.ProductViewImpl view;
    private ArrayList<Product> products = new ArrayList<>();

    public ProductPresenter(){
        model = new ProductModel(this);
    }


    @Override
    public void retrieveProduct(Bundle savedInstanceState) {
        if( savedInstanceState != null ){
            products = savedInstanceState.getParcelableArrayList( ProductActivity.MOTOS_KEY );

            return;
        }
        model.retrieveProduct();
    }

    @Override
    public void updateEhFavoritoProduct(Product product) {

    }

    @Override
    public void showToast(String mensagem) {
        view.showToast( mensagem );
    }

    @Override
    public void showProgressBar(boolean status) {
        int visibilidade = status ? View.VISIBLE : View.GONE;
        view.showProgressBar( visibilidade );
    }

    @Override
    public void setView(ProductIActivity.ProductViewImpl view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return null;
    }



    @Override
    public void updateListaRecycler(ArrayList<Product> m) {
        products.clear();
        products.addAll( m );
        view.updateListaRecycler();
    }


    @Override
    public void updateItemRecycler(Product prod) {
        for(int i = 0; i < products.size(); i++ ){
            if( products.get(i).getId() == prod.getId() ){
                products.get(i).setEhFavorito( prod.isEhFavorito() );
                view.updateItemRecycler( i );
                break;
            }
        }
    }

    @Override
    public ArrayList<Product> getProduct() {
        return products;
    }


}
