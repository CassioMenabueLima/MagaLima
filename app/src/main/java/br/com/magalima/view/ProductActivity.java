package br.com.magalima.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.magalima.R;
import br.com.magalima.adapter.ProductAdapter;
import br.com.magalima.domain.Login;
import br.com.magalima.domain.Product;
import br.com.magalima.presenter.ProductIPresenter;
import br.com.magalima.presenter.ProductPresenter;


public class ProductActivity extends AppCompatActivity implements ProductIActivity.ProductViewImpl {


    private ProductAdapter adapter;
    private static ProductIPresenter.ProductPresenterImpl presenter;
    private Login login;
    private RecyclerView rvProducts;
    private Button btn_comanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);
        Intent it = getIntent();
        login = (Login) it.getParcelableExtra("login");

        if (presenter == null) {
            presenter = new ProductPresenter();

        }
        presenter.setView(this);
        //   presenter.retrieveProduct( savedInstanceState );
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_comanda = findViewById(R.id.btn_comanda);
        actionButton();
        actionRecyclerView();

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(MOTOS_KEY, presenter.getProduct());

        super.onSaveInstanceState(outState);
        presenter.retrieveProduct(outState);
    }

    public void updateEhFavoritoMoto(Product product) {
        presenter.updateEhFavoritoProduct(product);
    }

    public void updateListaRecycler() {
        adapter.notifyDataSetChanged();
    }

    public void updateItemRecycler(int posicao) {
        adapter.notifyItemChanged(posicao);
    }


    @Override
    public void nextActivityProductDetails(Product product) {

        ProductActivityDetails productActivityDetails = new ProductActivityDetails(ProductActivity.this, login, product);
        productActivityDetails.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        productActivityDetails.show();
    }

    @Override
    public void nextActivityOrder(Login order) {
        Intent it = new Intent(this, OrderActivity.class);
        //it.putExtra("id", login.getId());
        it.putExtra("login", login);
        startActivity(it);
    }

    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    public void showProgressBar(int visibilidade) {
        findViewById(R.id.pb_loading).setVisibility(visibilidade);
    }

    public void actionButton() {
        btn_comanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.nextActivityOrder(login);
            }
        });
    }

    private void actionRecyclerView() {
        rvProducts = findViewById(R.id.rv_produtos);
        rvProducts.setHasFixedSize(true);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
        rvProducts.setLayoutManager(layoutManager);
        presenter.retrieveProduct(null);
        adapter = new ProductAdapter(this, presenter.getProduct());
        rvProducts.setAdapter(adapter);
    }

}