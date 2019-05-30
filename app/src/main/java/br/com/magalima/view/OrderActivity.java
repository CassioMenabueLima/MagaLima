package br.com.magalima.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import br.com.magalima.R;
import br.com.magalima.adapter.MotosAdapter;
import br.com.magalima.adapter.OrderAdapter;
import br.com.magalima.domain.Moto;
import br.com.magalima.mvp.MVP;
import br.com.magalima.mvp.Presenter;
import br.com.magalima.presenter.OrderIPresenter;
import br.com.magalima.presenter.OrderPresenter;


public class OrderActivity extends AppCompatActivity implements OrderIActivity.OrderViewImpl {


    private OrderAdapter adapter;
    private static OrderIPresenter.OrderPresenterImpl presenter;
    private String ID_USER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it = getIntent();
        ID_USER = it.getStringExtra("id");

        if (presenter == null) {
            presenter = new OrderPresenter();
        }
        presenter.setView(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        RecyclerView rvOrder = findViewById(R.id.rv_order);
        rvOrder.setHasFixedSize(true);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
        rvOrder.setLayoutManager(layoutManager);

        //adapter = new MotosAdapter( this, presenter.getMotos() );
        rvOrder.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(KEY, presenter.getOrder(ID_USER));
        super.onSaveInstanceState(outState);
    }


    public void updateListaRecycler() {
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