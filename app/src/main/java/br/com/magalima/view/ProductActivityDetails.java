package br.com.magalima.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import br.com.magalima.R;
import br.com.magalima.domain.Product;

public class ProductActivityDetails extends Dialog implements
        android.view.View.OnClickListener {



    private Activity c;
    private Dialog d;
    private Button yes, no;
    private TextView tv_informacoes;
    private String id;
    private Product product;

    public ProductActivityDetails(Activity a,String id, Product product) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.id =id;
        this.product=product;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.product_details);
        yes =  findViewById(R.id.btn_yes);
        no = findViewById(R.id.btn_no);
        tv_informacoes= findViewById(R.id.tv_informacoes);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

        tv_informacoes.setText(product.getInformacoes());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                ProductActivity productActivity = (ProductActivity) c;
                productActivity.showToast("Produto adicionado no carinho ");
                dismiss();
                break;
            case R.id.btn_no:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}