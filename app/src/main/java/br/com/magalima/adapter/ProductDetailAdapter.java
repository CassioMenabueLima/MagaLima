package br.com.magalima.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.magalima.MainActivity;
import br.com.magalima.R;
import br.com.magalima.domain.Moto;


public class ProductDetailAdapter extends RecyclerView.Adapter<ProductDetailAdapter.ViewHolder> {

    private MainActivity activity;
    private ArrayList<Moto> motos;


    public ProductDetailAdapter(MainActivity activity, ArrayList<Moto> motos ){
        this.activity = activity;
        this.motos = motos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from( parent.getContext() )
                .inflate(R.layout.product_itens, parent, false);
        ViewHolder viewHolder = new ViewHolder( view );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setDados( motos.get( position ) );
    }

    @Override
    public int getItemCount() {
        return motos.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivMoto;
        private ImageView ivFavorito;
        private TextView tvModelo;

        private ViewHolder(View itemView) {
            super(itemView);

            ivMoto = (ImageView) itemView.findViewById(R.id.iv_product);
            ivFavorito = (ImageView) itemView.findViewById(R.id.iv_favorito);
            tvModelo = (TextView) itemView.findViewById(R.id.tv_nome);

            ivFavorito.setOnClickListener( this );
        }

        private void setDados( Moto moto ){
            Picasso.with( ivMoto.getContext() )
                    .load( moto.getImagem() )
                    .into( ivMoto );

            tvModelo.setText( moto.getModelo() );
            ivFavorito.setImageResource( moto.getEhFavoritoIcone() );
        }

        @Override
        public void onClick(View view) {
            activity.updateEhFavoritoMoto( motos.get( getAdapterPosition() ) );
        }
    }
}