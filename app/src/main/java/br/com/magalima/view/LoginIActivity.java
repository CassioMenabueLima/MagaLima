package br.com.magalima.view;

import br.com.magalima.domain.Login;


public interface LoginIActivity {

    interface LoginViewImpl{
        String KEY = "login";

        public void showToast(String mensagem);
        public void showProgressBar(int visibilidade);
        public void nextActivity(Login login);
        public String getUserName();
        public String getPassword();
    }

}
