package br.com.magalima.model;


import java.util.ArrayList;

import br.com.magalima.db.DaoOrder;
import br.com.magalima.domain.Product;
import br.com.magalima.presenter.OrderIPresenter;


public class OrderModel implements OrderIModel.OrderModelImpl {

    private OrderIPresenter.OrderPresenterImpl presenter;
    private DaoOrder daoOrder;

    public OrderModel(OrderIPresenter.OrderPresenterImpl presenter) {
        this.presenter = presenter;
        this.daoOrder = new DaoOrder(presenter.getContext());
    }


    @Override
    public void addProductToOrder(Product product) {
        ArrayList<Product> lstProd  = new ArrayList<>();
        lstProd.add(product);
        int idOrder=daoOrder.getIdCurrentOrder();
        daoOrder.insertOrderItens(lstProd,idOrder);
    }

    @Override
    public void removeProductToOrder(Product product) {

    }

    @Override
    public void alterProductToOrder(Product product) {

    }

    @Override
    public void getOrders() {
        daoOrder = new DaoOrder(presenter.getContext());
        String ids=presenter.getIdUser();
        int id = Integer.parseInt(ids);
        ArrayList<Product> orders = daoOrder.getOrdersItens(id);
        presenter.updateListaRecycler(orders);

    }
}
