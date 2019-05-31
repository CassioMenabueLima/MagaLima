package br.com.magalima.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import br.com.magalima.domain.Order;
import br.com.magalima.domain.Product;
import br.com.magalima.network.JsonHttpRequestProduct;
import br.com.magalima.presenter.ProductIPresenter;


public class ProductModel implements ProductIModel.ProductModelImpl {
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private ProductIPresenter.ProductPresenterImpl presenter;

    public ProductModel(ProductIPresenter.ProductPresenterImpl presenter ){
        this.presenter = presenter;
    }

    @Override
    public void retrieveProduct() {
        RequestParams requestParams = new RequestParams(Product.ID_METODO, "get");
        asyncHttpClient.get( presenter.getContext(),
                JsonHttpRequestProduct.URI_PRODUTO,
                requestParams,
                new JsonHttpRequestProduct( presenter ));
    }




}
