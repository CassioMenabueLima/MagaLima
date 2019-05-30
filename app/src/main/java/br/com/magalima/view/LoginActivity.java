package br.com.magalima.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.magalima.R;
import br.com.magalima.adapter.MotosAdapter;
import br.com.magalima.db.DaoOrder;
import br.com.magalima.domain.Login;
import br.com.magalima.presenter.LoginIPresenter;
import br.com.magalima.presenter.LoginPresenter;


public class LoginActivity extends AppCompatActivity implements LoginIActivity.LoginViewImpl {


    private MotosAdapter adapter;
    private static LoginIPresenter.LoginPresenterImpl presenter;

    private EditText userName;
    private EditText password;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);


        if (presenter == null) {
            presenter = new LoginPresenter();
        }
        presenter.setView(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        userName = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signin);
        actionButton();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
       // outState.putParcelableArrayList(KEY, presenter.getLogin());
        super.onSaveInstanceState(outState);
    }


    @Override
    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(int visibilidade) {
         findViewById(R.id.pb_loading).setVisibility( visibilidade );
    }

    @Override
    public void nextActivity(Login login) {

        DaoOrder daoOrder = new DaoOrder(getBaseContext());
       // daoOrder.clearAllOrder();
        Intent it = new Intent(this, ProductActivity.class);
        //it.putExtra("id", login.getId());
        it.putExtra("login", login);
        startActivity(it);

        finish();

    }

    @Override
    public String getUserName() {
        return userName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    private void actionButton(){

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (! presenter.valideFields()) {
                    presenter.sendLogin(userName.getText().toString(), password.getText().toString());
                }else{
                   presenter.showToast("Campos obrigatorios nao preenchidos");
                }
            }
        });
    }
}