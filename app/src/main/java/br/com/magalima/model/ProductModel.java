package br.com.magalima.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

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
        RequestParams requestParams = new RequestParams(JsonHttpRequestProduct.METODO_KEY, "get-products");
        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequestProduct.URI,
                requestParams,
                new JsonHttpRequestProduct( presenter ));
    }




}
