package br.com.magalima.view;

import android.app.Activity;
import android.app.Dialog;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.magalima.R;
import br.com.magalima.db.DaoOrder;
import br.com.magalima.domain.Login;
import br.com.magalima.domain.Order;
import br.com.magalima.domain.Product;

public class ProductActivityDetails extends Dialog implements
        android.view.View.OnClickListener {


    private Activity c;
    private Dialog d;
    private Button yes, no;
    private TextView tv_informacoes;
    private TextView tv_price;
    private TextView tv_total;
    private EditText ed_quantity;
    private Login login;
    private Product product;
    private DaoOrder daoOrder;

    public ProductActivityDetails(Activity a, Login login, Product product) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.login = login;
        this.product = product;
        this.daoOrder = new DaoOrder(c.getBaseContext());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.product_details);
        yes = findViewById(R.id.btn_yes);
        no = findViewById(R.id.btn_no);
        tv_informacoes = findViewById(R.id.tv_informacoes);
        ed_quantity = findViewById(R.id.ed_quantity);
        tv_price = findViewById(R.id.tv_price);
        tv_total = findViewById(R.id.tv_total);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        tv_price.setText(String.valueOf(product.getValor()));
        tv_total.setText(String.valueOf(product.getValor() * product.getQuantity()));
        tv_informacoes.setText(product.getInformacoes());
        ed_quantity.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                double  quantidade =0;
               if (s.length()>0){
                   quantidade = Double.parseDouble(ed_quantity.getText().toString());
                }

                double price = Double.parseDouble(tv_price.getText().toString());
                double total = quantidade * price;
                tv_total.setText(String.valueOf(total));

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                ProductActivity productActivity = (ProductActivity) c;
                ArrayList<Order> lstOrder = new ArrayList<>();
                lstOrder = daoOrder.getOrders(login.getId());
                Order order = new Order();
                order.setLogin(login);
                ArrayList<Product> lstProd = new ArrayList<>();
                double qtd = Double.valueOf(ed_quantity.getText().toString());
                double price = Double.valueOf(tv_price.getText().toString());
                double total = qtd * price;
                product.setQuantity(qtd);
                product.setTotal(total);
                lstProd.add(product);
                order.setProducts(lstProd);
                daoOrder.insertOrder(order);

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