package br.com.magalima.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;

import br.com.magalima.domain.Login;
import br.com.magalima.domain.Order;
import br.com.magalima.domain.Product;


/**
 * Created by nalmir on 18/03/2017.
 */
public class DaoOrder extends Dao {


    public DaoOrder(Context context) {
        super(context);
    }

    public void insertOrder(Order order) {
        openDB();
          ContentValues cv = new ContentValues();
        // cv.put("id", null);
        cv.put("id_user", order.getLogin().getId());
        cv.put("name", order.getLogin().getName());
        cv.put("email", order.getLogin().getEmail());
        db.insert("order_header", null, cv);
        closeDB();
        if(order.getProducts() != null){
            //Insert Iten in order
            int idOrder =getIdCurrentOrder();
            insertOrderItens(order.getProducts(), idOrder);
        }
        //

    }

    public void insertOrderItens(ArrayList<Product> orderItem, int idOrder) {
        openDB();
        for (int i = 0; i < orderItem.size(); i++) {
            ContentValues cv = new ContentValues();
            // cv.put("id", null);
            cv.put("id_order", idOrder);
            cv.put("id_product", orderItem.get(i).getId());
            cv.put("description", orderItem.get(i).getDescricao());
            cv.put("price", orderItem.get(i).getValor());
            cv.put("quantity", orderItem.get(i).getQuantity());
            cv.put("total", orderItem.get(i).getTotal());
            cv.put("info", orderItem.get(i).getInformacoes());
            //
            db.insert("order_itens", null, cv);
            //
        }
        closeDB();

    }

    public int getIdCurrentOrder() {
        ArrayList<Order> dados = new ArrayList<>();
        int id = 0;
        //
        openDB();
        //
        Cursor cursor = null;
        //
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select * from order_header");

            cursor = db.rawQuery(sb.toString().toLowerCase(), null);

            while (cursor.moveToNext()) {

                id = cursor.getInt(cursor.getColumnIndex("id"));

            }

        } catch (Exception e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        //
        closeDB();
        //
        return id;
    }

    public void deleteOrder(int id) {
        openDB();
        //

        String where = " id= " + String.valueOf(id);
        // String[] argumentos = {chave};
        //Deletar Header
        db.delete("order_header", where, null);
        //Deletar Itens
        where = " id_order= " + String.valueOf(id);
        // String[] argumentos = {chave};
        //
        db.delete("order_header", where, null);
        closeDB();

    }

    public ArrayList<Order> getOrders(String idUser) {
        ArrayList<Order> dados = new ArrayList<>();
        //
        openDB();
        //
        Cursor cursor = null;
        //
        try {
            StringBuilder sb = new StringBuilder();
            //sb.append(" select * from order_header order by id ");

            sb.append(" select * from order_header where ")
                    .append("id_user")
                    .append(" = ? ");
            String[] argumentos = {idUser};
            cursor = db.rawQuery(sb.toString().toLowerCase(), argumentos);
            int i = 0;
            while (cursor.moveToNext()) {
              /*  byte [] foto =cursor.getBlob(cursor.getColumnIndex(Equipes.ESCUDO));
                String fotos =  Base64.encodeToString(foto, Base64.DEFAULT);*/

                //  String fotos= new String(foto);
                //   Base64.encode(fotos, Base64.DEFAULT);

                Order pAux = new Order();
                pAux.setId(cursor.getInt(cursor.getColumnIndex("id")));
                Login login = new Login();
                login.setId(cursor.getString(cursor.getColumnIndex("id_user")));
                login.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                login.setName(cursor.getString(cursor.getColumnIndex("name")));
                pAux.setLogin(login);
                pAux.setProducts(getOrdersItens(cursor.getInt(cursor.getColumnIndex("id"))));
                dados.add(pAux);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        //
        closeDB();
        //
        return dados;
    }

    public ArrayList<Product> getOrdersItens(int idOrder) {
        ArrayList<Product> dados = new ArrayList<>();
        //
        openDB();
        //
        Cursor cursor = null;
        //
        try {
            StringBuilder sb = new StringBuilder();
            sb
                    .append(" select * from order_itens where ")
                    .append("id_order")
                    .append(" = ? ");

            String[] argumentos = {String.valueOf(idOrder)};

            cursor = db.rawQuery(sb.toString().toLowerCase(), argumentos);
            while (cursor.moveToNext()) {
                Product pAux = new Product();
                pAux.setDescricao(cursor.getString(cursor.getColumnIndex("description")));
                pAux.setId(cursor.getString(cursor.getColumnIndex("id_product")));
                pAux.setInformacoes(cursor.getString(cursor.getColumnIndex("info")));
                pAux.setQuantity(cursor.getDouble(cursor.getColumnIndex("quantity")));
                pAux.setValor(cursor.getDouble(cursor.getColumnIndex("price")));
                pAux.setTotal(cursor.getDouble(cursor.getColumnIndex("total")));
                dados.add(pAux);

            }

        } catch (Exception e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        //
        closeDB();
        //
        return dados;
    }
    public void clearAllOrder() {
        openDB();
        //

        String where =   " 1= 1";
        // String[] argumentos = {chave};
        //
        db.delete("order_header", where, null);
        db.delete("order_itens", where, null);
        closeDB();

    }
}
