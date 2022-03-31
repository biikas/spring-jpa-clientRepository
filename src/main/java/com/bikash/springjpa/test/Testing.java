package com.bikash.springjpa.test;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Testing {
    public static void main(String[] args) {
        Testing.Post_JSON();


    }
    public static void Post_JSON(){
        String queryUrl="http://localhost:8084/clients/add";
        String json="{\"name\":\"sudip.test\",\"username\":\"sudip11.test\",\"active\":\"Y\",\"password\":\"sudip.test\"}";
        try{
            URL url = new URL(queryUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("content-type","application/json;charset-UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os =conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();

            //read the response
            InputStream in= new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in,"UTF-8");
            System.out.println(result);
            System.out.println("reading after json response");

            JSONObject myResponse =new JSONObject(result);

            in.close();
            conn.disconnect();

        }catch (Exception e){
            System.out.println(e);
        }

    }

}
