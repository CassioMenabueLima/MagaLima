package br.com.magalima.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;

import br.com.magalima.R;
import br.com.magalima.domain.Product;
import br.com.magalima.view.OrderActivity;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private OrderActivity activity;
    private ArrayList<Product> order;


    public OrderAdapter(OrderActivity activity, ArrayList<Product> order) {
        this.activity = activity;
        this.order = order;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.order_itens, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setDados(order.get(position));
    }

    @Override
    public int getItemCount() {
        return order.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_nome;
        private TextView tv_quantidade;
        private TextView tv_preco;
        private TextView tv_total;

        private ViewHolder(View itemView) {
            super(itemView);

            tv_nome = itemView.findViewById(R.id.tv_nome);
            tv_quantidade = itemView.findViewById(R.id.tv_quantidade);
            tv_preco = itemView.findViewById(R.id.tv_preco);
            tv_total = itemView.findViewById(R.id.tv_total);

        }

        private void setDados(Product order) {
            tv_nome.setText("Produto " + String.valueOf(order.getDescricao()));
            tv_quantidade.setText("Quantidade: " + String.valueOf(order.getQuantity()));
            tv_preco.setText("Preco: " + String.valueOf(order.getValor()));
            tv_total.setText("Total: " + String.valueOf(order.getTotal()));

        }

        @Override
        public void onClick(View view) {

        }
    }
}