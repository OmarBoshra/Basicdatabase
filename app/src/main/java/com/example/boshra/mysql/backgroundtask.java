package com.example.boshra.mysql;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by boshra on 9/13/2017.
 */

public class backgroundtask extends AsyncTask<String,Void,String> {

   Context cx;
    public backgroundtask(Context x) {
        this.cx=x;
    }

    @Override
    protected void onPreExecute() {

    }


    protected void onPostExecute(String result) {


            Toast.makeText(cx, result, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {

    }

    @Override




    protected String doInBackground(String[] objects) {



        String action = objects[0];
        String name = objects[1];
        String age = objects[2];
        String newname = objects[3];


return logreg(action,name,age,newname);
    }
    public String logreg(String action,String name,String age,String nname){

        String reg_url="http://192.168.1.4/server/insertion.php";
        String login_url="http://192.168.1.4/server/retrive.php";
        String save_url="http://192.168.1.4/server/update.php";
        String delete_url="http://192.168.1.4/server/delete.php";


        if(action.equals("register")||action.equals("login")||action.equals("update")||action.equals("delete")) {




            try {
                URL  url = new URL(action.equals("register")?reg_url:action.equals("login")?login_url:action.equals("update")?save_url:delete_url);

               String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&&"+
                        URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&&"+URLEncoder.encode("nname","UTF-8")+"="+URLEncoder.encode(nname,"UTF-8")+"&&"+URLEncoder.encode("nage","UTF-8")+"="+URLEncoder.encode(age,"UTF-8");

                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);


                    httpURLConnection.setDoInput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));


                bw.write(data);
                bw.flush();
                bw.close();
                os.close();

                InputStream is =httpURLConnection.getInputStream();


                    BufferedReader br = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                    String response="";
                    String line;

                    while((line=br.readLine())!=null){
                        response+=line;
                    }
                   br.close();
                    is.close();
                    httpURLConnection.disconnect();
                    return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         return "no operation executed";

    }
}
