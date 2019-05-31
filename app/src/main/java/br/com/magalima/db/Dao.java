package br.com.magalima.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.magalima.util.Constantes;


public class Dao {

    private Context context;
    protected SQLiteDatabase db;

    public Dao(Context context) {
        this.context = context;
    }

    //

    public void openDB() {
        StringBuilder sb = new StringBuilder();
        DataBaseHelper baseHelper = new DataBaseHelper(
                context,
                Constantes.BANCODEDADOS,
                null,
                Constantes.VERSAO_BANCO,sb
        );

        this.db = baseHelper.getWritableDatabase();

    }

    // Ensinei ele a fechar o banco de dados
    public void closeDB() {
        if (db != null) {
            db.close();
        }
    }
}
