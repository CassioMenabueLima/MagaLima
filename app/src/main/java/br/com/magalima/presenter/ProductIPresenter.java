package br.com.magalima.presenter;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Login;
import br.com.magalima.domain.Product;
import br.com.magalima.view.ProductIActivity;


public interface ProductIPresenter {

    interface ProductPresenterImpl{
        public void retrieveProduct(Bundle savedInstanceState);
        public void updateEhFavoritoProduct(Product product);
        public void showToast(String mensagem);
        public void showProgressBar(boolean status);
        public void setView(ProductIActivity.ProductViewImpl view);
        public Context getContext();
        public void updateListaRecycler(ArrayList<Product> product);

        public ArrayList<Product> getProduct();
        public void nextActivityOrder(Login login);
    }



}
