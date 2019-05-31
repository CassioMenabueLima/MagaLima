package br.com.magalima.view;

import br.com.magalima.domain.Login;
import br.com.magalima.domain.Product;


public interface ProductIActivity {

    interface ProductViewImpl{
        String MOTOS_KEY = "products";

        public void showToast(String mensagem);
        public void showProgressBar(int visibilidade);
        public void updateListaRecycler();
      
        public void nextActivityProductDetails(Product product);
        public void nextActivityOrder(Login product);
    }

}
