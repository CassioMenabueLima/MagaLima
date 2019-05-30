package br.com.magalima.model;

import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;

import br.com.magalima.db.DaoOrder;
import br.com.magalima.domain.Moto;
import br.com.magalima.domain.Product;
import br.com.magalima.presenter.OrderIPresenter;


public class OrderModel implements OrderIModel.OrderModelImpl {
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private OrderIPresenter.OrderPresenterImpl presenter;
    private DaoOrder daoOrder;

    public OrderModel(OrderIPresenter.OrderPresenterImpl presenter) {
        this.presenter = presenter;
        this.daoOrder = new DaoOrder(presenter.getContext());
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
    public void getProducts() {
        String id = (presenter.getIdUser());
        presenter.updateListaRecycler(daoOrder.getOrders(id));
    }
}
