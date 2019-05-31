package br.com.magalima.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import br.com.magalima.domain.Login;

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
    public void sendLogin(String userName, String password) {
        RequestParams requestParams = new RequestParams();
        requestParams.put(Login.ID_USERNAME, userName );
        requestParams.put( Login.ID_PASSWORD, password );

        asyncHttpClient.get( presenter.getContext(),
                JsonHttpRequestLogin.URI,
                requestParams,
                new JsonHttpRequestLogin( presenter ));
    }


}

