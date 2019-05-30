package br.com.magalima.util;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ToolBox {
    /*public static String criaImagensJson(Images img) throws JSONException {
        JSONObject retJson = new JSONObject();
        Gson gson = new Gson();
        String json = "";
        try {
            retJson.put("imagem", img);
            //convert java object to JSON format
            json = gson.toJson(img);
            System.out.println(json);//   json= retJson.

        } catch (Exception e) {
            e.printStackTrace();
        }


        return json;
    }
*/
    public static String PegarData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        // OU
        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        String data_completa = dateFormat.format(data_atual);
        String hora_atual = dateFormat_hora.format(data_atual);
        return data_completa;
    }

    public static String PegarHora() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
        // OU
        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        String data_completa = dateFormat.format(data_atual);
        String hora_atual = dateFormat_hora.format(data_atual);
        return hora_atual;
    }

    public static String webServices(Boolean local) {
        String URL_JSON = "http://177.36.128.62:5199/REST/WBSVLOG01?chave=AIzaSyD2HjdbDPUP8YbqjBLlrxzoFhNQJsK6MTk"; //"http://menabue.ddns.net:8084/REST/WBSV01?chave=AIzaSyD2HjdbDPUP8YbqjBLlrxzoFhNQJsK6MTk";
        if (local) {
            URL_JSON = "http://192.168.13.17:8084/REST/WBSVLOG01?chave=AIzaSyD2HjdbDPUP8YbqjBLlrxzoFhNQJsK6MTk";
        }


        return URL_JSON;
    }

    public static String retiraCaracteresEspeciais(String stringFonte)

    {

        String passa = stringFonte;

        passa = passa.replaceAll("[ÂÀÁÄÃ]", "A");

        passa = passa.replaceAll("[âãàáä]", "a");

        passa = passa.replaceAll("[ÊÈÉË]", "E");

        passa = passa.replaceAll("[êèéë]", "e");

        passa = passa.replaceAll("ÎÍÌÏ", "I");

        passa = passa.replaceAll("îíìï", "i");

        passa = passa.replaceAll("[ÔÕÒÓÖ]", "O");

        passa = passa.replaceAll("[ôõòóö]", "o");

        passa = passa.replaceAll("[ÛÙÚÜ]", "U");

        passa = passa.replaceAll("[ûúùü]", "u");

        passa = passa.replaceAll("Ç", "C");

        passa = passa.replaceAll("ç", "c");

        passa = passa.replaceAll("[ýÿ]", "y");

        passa = passa.replaceAll("Ý", "Y");

        passa = passa.replaceAll("ñ", "n");

        passa = passa.replaceAll("Ñ", "N");

        passa = passa.replaceAll("[+=*&amp;%$#@!:]", "");

        passa = passa.replaceAll("['\"]", "-");

        passa = passa.replaceAll("[<>()\\{\\}]", "");

        passa = passa.replaceAll("['\\\\,()|/]", "-");

        passa = passa.replaceAll("[^!-ÿ]{1}[^ -ÿ]{0,}[^!-ÿ]{1}|[^!-ÿ]{1}", " ");

        return passa;

    }
}

