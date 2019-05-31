package br.com.magalima.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.magalima.R;
import br.com.magalima.domain.Product;
import br.com.magalima.view.ProductActivity;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ProductActivity activity;
    private ArrayList<Product> products;


    public ProductAdapter(ProductActivity activity, ArrayList<Product> product ){
        this.activity = activity;
        this.products = product;
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
        holder.setDados( products.get( position ) );
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView iv_product;
        private ImageView iv_favourite;
        private TextView tv_nome;
        private TextView tv_valor;
        private Button btn_details;
        private ViewHolder(View itemView) {
            super(itemView);

            iv_product =  itemView.findViewById(R.id.iv_product);
            iv_favourite =  itemView.findViewById(R.id.iv_favorito);
            tv_nome = itemView.findViewById(R.id.tv_nome);
            tv_valor = itemView.findViewById(R.id.tv_valor);
            btn_details = itemView.findViewById(R.id.btn_details);
            iv_favourite.setOnClickListener( this );
        }

        private void setDados( Product product ){
           /* Picasso.with( iv_product.getContext() )
                    .load( product.getInformacoes() )
                    .into(iv_product);*/
            tv_nome.setText( product.getDescricao() );
            tv_valor.setText(String.valueOf(product.getValor()) );

            btn_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   activity.nextActivityProductDetails(products.get(getAdapterPosition()));
                }
            });
        }

        @Override
        public void onClick(View view) {


        }
    }
}