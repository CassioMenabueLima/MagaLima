package br.com.magalima.network;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import br.com.magalima.domain.Login;
import br.com.magalima.domain.Moto;
import br.com.magalima.mvp.MVP;
import br.com.magalima.presenter.LoginIPresenter;
import cz.msebera.android.httpclient.Header;


public class JsonHttpRequestLogin extends JsonHttpResponseHandler {
    public static final String URI = "http://192.168.0.2:8081/produto/usuarios.php";
    public static final String METODO_KEY = "metodo";

    private LoginIPresenter.LoginPresenterImpl presenter;


    public JsonHttpRequestLogin(LoginIPresenter.LoginPresenterImpl presenter ){
        this.presenter = presenter;
    }

    @Override
    public void onStart() {
        presenter.showProgressBar( true );
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        Gson gson = new Gson();
        Login login = gson.fromJson( response.toString(), Login.class );
     //   presenter.updateItemRecycler( m );
        presenter.setLogin(login);


    }


    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        presenter.showToast( responseString );
        presenter.setLogin(null);
    }

    @Override
    public void onFinish() {
        presenter.showProgressBar( false );
    }
}