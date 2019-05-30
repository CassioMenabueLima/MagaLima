package br.com.magalima.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import br.com.magalima.domain.Moto;
import br.com.magalima.domain.Product;
import br.com.magalima.mvp.MVP;
import br.com.magalima.network.JsonHttpRequest;
import br.com.magalima.network.JsonHttpRequestProduct;
import br.com.magalima.presenter.ProductIPresenter;
import br.com.magalima.presenter.ProductPresenter;


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

    @Override
    public void updateEhFavoritoMoto(Product product) {
        RequestParams requestParams = new RequestParams(JsonHttpRequestProduct.METODO_KEY, "get-products");
        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequestProduct.URI,
                requestParams,
                new JsonHttpRequestProduct( presenter ));
    }



    /*@Override
    public void retrieveProduct() {
        RequestParams requestParams = new RequestParams(JsonHttpRequest.METODO_KEY, "get-motos");
        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequest.URI,
                requestParams,
                new JsonHttpRequest( presenter ));
    }

    @Override
    public void updateEhFavoritoMoto(Moto moto) {
        RequestParams requestParams = new RequestParams();
        requestParams.put( JsonHttpRequest.METODO_KEY, "update-favorito-moto" );
        requestParams.put( Moto.ID_KEY, moto.getId() );
        requestParams.put( Moto.EH_FAVORITO_KEY, moto.isEhFavorito() );

        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequest.URI,
                requestParams,
                new JsonHttpRequest( presenter ));
    }*/
}
