package br.com.magalima.network;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import br.com.magalima.domain.Product;
import br.com.magalima.presenter.ProductIPresenter;
import br.com.magalima.util.Constantes;
import cz.msebera.android.httpclient.Header;


public class JsonHttpRequestProduct extends JsonHttpResponseHandler {
    public static final String URI = Constantes.IP_API+Product.ID_METODO;


    private ProductIPresenter.ProductPresenterImpl presenter;


    public JsonHttpRequestProduct(ProductIPresenter.ProductPresenterImpl presenter ){
        this.presenter = presenter;
    }

    @Override
    public void onStart() {
        presenter.showProgressBar( true );
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        Gson gson = new Gson();
        Product product = gson.fromJson( response.toString(), Product.class );
        ArrayList<Product> products = new ArrayList<>();
        products.add( product );
        presenter.updateListaRecycler( products );


    }
   @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        Gson gson = new Gson();
        ArrayList<Product> products = new ArrayList<>();
        Product m;

        for( int i = 0; i < response.length(); i++ ){
            try{
                m = gson.fromJson( response.getJSONObject( i ).toString(), Product.class );
                products.add( m );
            }
            catch(JSONException e){}
        }
        presenter.updateListaRecycler( products );
    }
    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        presenter.showToast( responseString );


    }

    @Override
    public void onFinish() {
        presenter.showProgressBar( false );
    }
}