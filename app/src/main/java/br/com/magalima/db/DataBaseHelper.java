package br.com.magalima.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper extends SQLiteOpenHelper {
    public StringBuilder sb;

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, StringBuilder sbs) {

        super(context, name, factory, version);
        this.sb = sbs;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            if (sb == null) {
                sb = new StringBuilder();
            }

            sb = new StringBuilder();
            sb.append("CREATE TABLE IF NOT EXISTS [ORDER_HEADER] ( " +
                    "  [ID] INTEGER PRIMARY KEY AUTOINCREMENT ,  " +
                    "  [ID_USER] TEXT , " +
                    "  [NAME] TEXT ,  " +
                    "  [EMAIL] TEXT  " +
                    "    );");
            sb.append("CREATE TABLE IF NOT EXISTS [ORDER_ITENS] ( " +
                    "  [ID_ORDER] INTEGER ,  " +
                    "  [ID_PRODUCT] TEXT , " +
                    "  [DESCRIPTION] TEXT ,  " +
                    "  [PRICE] REAL ,  " +
                    "  [QUANTTY] REAL ,  " +
                    "  [TOTAL] REAL ,  " +
                    "  [INFO] TEXT  " +
                    "    );");
            String[] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i].toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {

            StringBuilder sb = new StringBuilder();
            //
            // Tabela Contato
            sb.append("DROP TABLE IF EXISTS [ORDER_HEADER] ;");
            sb.append("DROP TABLE IF EXISTS [ORDER_ITENS] ;");
            // Tabel Ramo Atividade
            //sb.append("");

            String[] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i].toLowerCase());
            }


        } catch (Exception e) {
        }

        onCreate(db);
    }
}

