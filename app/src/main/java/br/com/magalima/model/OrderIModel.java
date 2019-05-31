package br.com.magalima.model;

import br.com.magalima.domain.Product;


public interface OrderIModel {
    interface OrderModelImpl {

        public void addProductToOrder(Product product);
        public void removeProductToOrder(Product product);
        public void alterProductToOrder(Product product);
        public void getOrders();

    }


}
