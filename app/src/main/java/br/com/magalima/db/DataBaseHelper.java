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

                // Tabela Contato
                //  sb = LogisticaHttp.carregaDados("1", "SZYconsultar", "", "", "", "");
           /* sb.append("CREATE TABLE IF NOT EXISTS [" + Constantes.TABELA + "] ( " +
                    "  [" + Constantes.B2_DATA + "] TEXT ,  " +
                    "  [" + Constantes.B2_COD + "] TEXT , " +
                    "  [" + Constantes.B2_DESC+ "] TEXT ,  " +
                    "  [" + Constantes.B2_EMP+ "] TEXT , " +
                    "  [" + Constantes.B2_SALDO + "] TEXT  " +
                    "    );");*/


                String[] comandos = sb.toString().split(";");

                for (int i = 0; i < comandos.length; i++) {
                    db.execSQL(comandos[i].toLowerCase());
                }
                sb = new StringBuilder();
                sb.append("CREATE TABLE IF NOT EXISTS [CAMPOS] ( " +
                        "  [TITULO] TEXT ,  " +
                        "  [TIPO] TEXT , " +
                        "  [TAMANHO] TEXT ,  " +
                        "  [DECIMAL] TEXT  " +
                        "    );");
                comandos = sb.toString().split(";");

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
            //    sb.append("DROP TABLE IF EXISTS [" + Constantes.TABELA + "] ;");

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

