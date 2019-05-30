package br.com.magalima.model;

import com.loopj.android.http.AsyncHttpClient;

import br.com.magalima.domain.Moto;
import br.com.magalima.presenter.OrderIPresenter;


public class OrderModel implements OrderIModel.CarModelImpl {
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private OrderIPresenter.CarPresenterImpl presenter;

    public OrderModel(OrderIPresenter.CarPresenterImpl presenter ){
        this.presenter = presenter;
    }

    @Override
    public void retrieveMotos() {
       /* RequestParams requestParams = new RequestParams(JsonHttpRequest.METODO_KEY, "get-motos");
        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequest.URI,
                requestParams,
                new JsonHttpRequest( presenter ));*/
    }

    @Override
    public void updateEhFavoritoMoto(Moto moto) {
      /*  RequestParams requestParams = new RequestParams();
        requestParams.put( JsonHttpRequest.METODO_KEY, "update-favorito-moto" );
        requestParams.put( Moto.ID_KEY, moto.getId() );
        requestParams.put( Moto.EH_FAVORITO_KEY, moto.isEhFavorito() );

        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequest.URI,
                requestParams,
                new JsonHttpRequest( presenter ));*/
    }
}
