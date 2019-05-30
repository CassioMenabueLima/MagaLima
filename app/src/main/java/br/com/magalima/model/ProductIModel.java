package br.com.magalima.model;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Moto;
import br.com.magalima.domain.Product;


public interface ProductIModel {
    interface ProductModelImpl{
        public void retrieveProduct();
        public void updateEhFavoritoMoto(Product product);
    }



}
