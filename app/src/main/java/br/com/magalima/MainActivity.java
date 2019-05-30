package br.com.magalima;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import br.com.magalima.adapter.MotosAdapter;
import br.com.magalima.domain.Moto;
import br.com.magalima.mvp.MVP;
import br.com.magalima.mvp.Presenter;


public class MainActivity extends AppCompatActivity implements MVP.ViewImpl {


    private MotosAdapter adapter;
    private static MVP.PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if( presenter == null ){
            presenter = new Presenter();
        }
        presenter.setView( this );
        presenter.retrieveMotos( savedInstanceState );
    }

    @Override
    protected void onStart() {
        super.onStart();

        RecyclerView rvMotos =  findViewById(R.id.rv_motos);
        rvMotos.setHasFixedSize(true);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
        rvMotos.setLayoutManager( layoutManager );

        adapter = new MotosAdapter( this, presenter.getMotos() );
        rvMotos.setAdapter( adapter );
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(MOTOS_KEY, presenter.getMotos());
        super.onSaveInstanceState(outState);
    }

    public void updateEhFavoritoMoto( Moto moto ){
        presenter.updateEhFavoritoMoto( moto );
    }

    public void updateListaRecycler(){
        adapter.notifyDataSetChanged();
    }

    public void updateItemRecycler( int posicao ){
        adapter.notifyItemChanged( posicao );
    }

    public void showToast( String mensagem ){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    public void showProgressBar( int visibilidade ){
        findViewById(R.id.pb_loading).setVisibility( visibilidade );
    }
}