package br.com.magalima.mvc.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import br.com.magalima.db.Dao;
import br.com.magalima.mvc.model.HAux;

public class CarDao extends Dao {

    public CarDao(Context context) {
        super(context);
    }

    public void droptable(StringBuilder sb) {
        try {
            StringBuilder sb1 = new StringBuilder();
            abrirBanco(sb1);

            //
            // Tabela Contato
            //sb.append("DROP TABLE IF EXISTS [" + Constantes.TABELA + "] ;");

            // Tabel Ramo Atividade
            //sb.append("");

            String[] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i].toLowerCase());
            }


        } catch (Exception e) {
        }
    }

    public void createTable(StringBuilder sb) {
        String[] comandos = sb.toString().split(";");
        StringBuilder sb1 = new StringBuilder();
        abrirBanco(sb1);
        for (int i = 0; i < comandos.length; i++) {
            db.execSQL(comandos[i].toLowerCase());
        }
    }

    public void insertFields(JSONArray jsonCamposArray) {
        //   apagarTodosSZX();
        StringBuilder sb = new StringBuilder();
        abrirBanco(sb);
        //
        String cTabela = "";
        ContentValues cv = new ContentValues();

        try {

            JSONObject jsonCamposObject = null;

            jsonCamposObject = jsonCamposArray.getJSONObject(0);
            for (int j = 1; j < jsonCamposObject.length(); j++) {
                String campo = null;
                cv = new ContentValues();
                campo = jsonCamposObject.getString(String.valueOf(j)).trim();
                cv.put("TITULO", campo);
                long ret = db.insert("CAMPOS".toLowerCase(), null, cv);
                long retorno = ret;


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        fecharBanco();
    }

    public ArrayList<HAux> getDados() {
        ArrayList<HAux> dados = new ArrayList<>();
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //

        try {
            StringBuilder sb = new StringBuilder();
            // sb.append(" select * from " + cTabela+ " order by " + Constantes.B2_COD + " ");
            sb.append(" select * from CAMPOS ");
            cursor = db.rawQuery(sb.toString().toLowerCase(), null);
            String campo = "";
            int nIndice = 0;
            while (cursor.moveToNext()) {
                HAux hmAux = new HAux();

                hmAux.put(String.valueOf(nIndice), cursor.getString(0));

                nIndice++;
                dados.add(hmAux);

            }

        } catch (Exception e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        //
        fecharBanco();
        //
        return dados;
    }

    public void inserir(JSONArray jsonCamposArray, JSONArray jsonConteudos) {
        //   apagarTodosSZX();
        StringBuilder sb = new StringBuilder();
        abrirBanco(sb);
        //
        String cTabela = "";
        ContentValues cv = new ContentValues();
        for (int i = 0; i <= jsonConteudos.length() - 1; i++) {

            JSONObject jsonConteudosLinha = null;
            try {
                jsonConteudosLinha = jsonConteudos.getJSONObject(i);
                JSONObject jsonCamposObject = null;
                try {
                    jsonCamposObject = jsonCamposArray.getJSONObject(0);
                    for (int j = 1; j < jsonCamposObject.length(); j++) {
                        String campo = null;
                        try {
                            campo = jsonCamposObject.getString(String.valueOf(j)).trim();
                            cTabela = "S" + campo.substring(0, 2);
                            try {
                                cv.put(campo, jsonConteudosLinha.getString(campo));
                                //hmaux.put(campo, jsonConteudosLinha.getString(campo));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            long ret = db.insert(cTabela.toLowerCase(), null, cv);
            long retorno = ret;
        }

       /* cv.put(Constantes.B2_COD, SB2.B2_COD);
        cv.put(Constantes.B2_DESC, SB2.B2_DESC);
        cv.put(Constantes.B2_EMP, SB2.B2_EMP);
        cv.put(Constantes.B2_SALDO, SB2.B2_SALDO);
*/

        //

        //

        fecharBanco();
    }

    public ArrayList<HAux> obterDados(String cTabela, JSONArray jsonCamposArray) {
        ArrayList<HAux> dados = new ArrayList<>();
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //

        try {
            StringBuilder sb = new StringBuilder();
            // sb.append(" select * from " + cTabela+ " order by " + Constantes.B2_COD + " ");
            sb.append(" select * from " + cTabela + " ");
            cursor = db.rawQuery(sb.toString().toLowerCase(), null);
            String campo = "";

            while (cursor.moveToNext()) {
                JSONObject jsonCamposObject = null;

                jsonCamposObject = jsonCamposArray.getJSONObject(0);
                HAux hmAux = new HAux();
                for (int j = 1; j < jsonCamposObject.length(); j++) {

                    campo = jsonCamposObject.getString(String.valueOf(j));

                    hmAux.put(campo.trim(), cursor.getString(cursor.getColumnIndex(campo.trim().toLowerCase())));
                }

               /* hmAux.put(Constantes.B2_COD, cursor.getString(cursor.getColumnIndex(Constantes.B2_COD)));
                hmAux.put(Constantes.B2_DESC, cursor.getString(cursor.getColumnIndex(Constantes.B2_DESC)));
                hmAux.put(Constantes.B2_EMP, cursor.getString(cursor.getColumnIndex(Constantes.B2_EMP)));
                hmAux.put(Constantes.B2_SALDO, cursor.getString(cursor.getColumnIndex(Constantes.B2_SALDO)));*/


                dados.add(hmAux);

            }

        } catch (Exception e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        //
        fecharBanco();
        //
        return dados;
    }
}

