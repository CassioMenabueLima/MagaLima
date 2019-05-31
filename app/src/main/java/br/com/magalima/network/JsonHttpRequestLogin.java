package br.com.magalima.network;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.magalima.domain.Login;

import br.com.magalima.presenter.LoginIPresenter;
import cz.msebera.android.httpclient.Header;


public class JsonHttpRequestLogin extends JsonHttpResponseHandler {
    public static final String URI = "http://192.168.0.2:8081/produto/usuarios.php";


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

    @Override
    protected Object parseResponse(byte[] responseBody) throws JSONException {
        return super.parseResponse(responseBody);
    }

    @Override
    public boolean isUseRFC5179CompatibilityMode() {
        return super.isUseRFC5179CompatibilityMode();
    }

    @Override
    public void setUseRFC5179CompatibilityMode(boolean useRFC5179CompatibilityMode) {
        super.setUseRFC5179CompatibilityMode(useRFC5179CompatibilityMode);
    }
}