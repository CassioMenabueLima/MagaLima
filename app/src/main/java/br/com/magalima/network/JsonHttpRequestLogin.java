package br.com.magalima.network;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.magalima.domain.Login;

import br.com.magalima.presenter.LoginIPresenter;
import br.com.magalima.util.Constantes;
import cz.msebera.android.httpclient.Header;


public class JsonHttpRequestLogin extends JsonHttpResponseHandler {
    public static final String URI = Constantes.IP_API+Login.ID_METODO;


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

        if(!login.getId().contains("0")){
            presenter.setLogin(login);
        }else{
            presenter.showToast("Login Invalido");
        }



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


    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        super.onSuccess(statusCode, headers, response);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        super.onFailure(statusCode, headers, throwable, errorResponse);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        super.onFailure(statusCode, headers, throwable, errorResponse);
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        super.onSuccess(statusCode, headers, responseString);
    }



}