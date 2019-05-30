package br.com.magalima.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import br.com.magalima.domain.Moto;
import br.com.magalima.mvp.MVP;
import br.com.magalima.network.JsonHttpRequest;
import br.com.magalima.network.JsonHttpRequestLogin;
import br.com.magalima.presenter.LoginIPresenter;
import br.com.magalima.presenter.LoginPresenter;


public class LoginModel implements LoginIModel.LoginModelImpl {
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private LoginIPresenter.LoginPresenterImpl presenter;


    public LoginModel(LoginPresenter presenter ){
        this.presenter = presenter;
    }

    @Override
    public void retrieveLogon() {
        RequestParams requestParams = new RequestParams(JsonHttpRequestLogin.METODO_KEY, "logar");
        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequestLogin.URI,
                requestParams,
                new JsonHttpRequestLogin( presenter ));
    }

    @Override
    public void sendLogin(String userName, String password) {
        RequestParams requestParams = new RequestParams();
        requestParams.put( JsonHttpRequest.METODO_KEY, "send-login" );
        requestParams.put( Moto.ID_KEY, userName );
        requestParams.put( Moto.EH_FAVORITO_KEY, password );

        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequestLogin.URI,
                requestParams,
                new JsonHttpRequestLogin( presenter ));
    }


}
