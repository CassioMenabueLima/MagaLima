package br.com.magalima.model;


import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;

import br.com.magalima.db.DaoOrder;
import br.com.magalima.domain.Product;
import br.com.magalima.network.JsonHttpRequestOrder;
import br.com.magalima.network.JsonHttpRequestProduct;
import br.com.magalima.presenter.OrderIPresenter;
import cz.msebera.android.httpclient.entity.StringEntity;
import okhttp3.Request;


public class OrderModel implements OrderIModel.OrderModelImpl {
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private OrderIPresenter.OrderPresenterImpl presenter;
    private DaoOrder daoOrder;
    private static Request request;
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
        Gson jsonParams = new Gson();
        jsonParams.toJson(product);
        RequestParams params = new RequestParams();
        params.put("product", jsonParams);
        asyncHttpClient.post(presenter.getContext(),JsonHttpRequestOrder.URI_ITEM, params,  new JsonHttpRequestOrder( presenter ));

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
