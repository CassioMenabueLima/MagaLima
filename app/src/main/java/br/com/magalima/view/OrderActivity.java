package br.com.magalima.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.magalima.R;
import br.com.magalima.adapter.OrderAdapter;
import br.com.magalima.domain.Login;

import br.com.magalima.presenter.OrderIPresenter;
import br.com.magalima.presenter.OrderPresenter;


public class OrderActivity extends AppCompatActivity implements OrderIActivity.OrderViewImpl {


    private OrderAdapter adapter;
    private static OrderIPresenter.OrderPresenterImpl presenter;
    private String ID_USER;
    private RecyclerView rvOrder;
    private Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);

        Intent it = getIntent();
        Login login = it.getParcelableExtra("login");
        ID_USER = login.getId();

        if (presenter == null) {
            presenter = new OrderPresenter();
        }
        presenter.setView(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_close = findViewById(R.id.btn_close);
        rvOrder = findViewById(R.id.rv_order);
        actionRecyclerView();
        actionButton();
    }

    private void actionButton() {

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void actionRecyclerView() {
        rvOrder.setHasFixedSize(true);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
        rvOrder.setLayoutManager(layoutManager);
        presenter.retrieveOrder(null);
        adapter = new OrderAdapter(this, presenter.getOrder());
        rvOrder.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(KEY, presenter.getOrder());
        super.onSaveInstanceState(outState);
        presenter.retrieveOrder(outState);
    }


    public void updateListaRecycler() {
        adapter = new OrderAdapter(this, presenter.getOrder());
        adapter.notifyDataSetChanged();
    }

    public void updateItemRecycler(int posicao) {

        adapter.notifyItemChanged(posicao);
    }

    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    public void showProgressBar(int visibilidade) {
        findViewById(R.id.pb_loading).setVisibility(visibilidade);
    }

    @Override
    public String getIdUser() {
        return ID_USER;
    }
}