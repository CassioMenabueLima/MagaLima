package br.com.magalima.model;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Moto;
import br.com.magalima.domain.Product;


public interface OrderIModel {
    interface OrderModelImpl {
        public void retrieveMotos();
        public void updateEhFavoritoMoto(Moto moto);
        public void addProductToOrder(Product product);
        public void removeProductToOrder(Product product);
        public void alterProductToOrder(Product product);
        public void getProducts();

    }


}
