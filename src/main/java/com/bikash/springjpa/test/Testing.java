package com.bikash.springjpa.test;

import com.bikash.springjpa.controller.ClientController;
import lombok.var;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Testing {
    public static void main(String[] args) {
        String json="{\"name\":\"sudip.test\",\"username\":\"sudip.test\",\"active\":\"Y\",\"password\":\"sudip.test\"}";
        var url ="http://localhost:8084/clients/add";




//            URL url =new URL("http://localhost:8084/clients/add");
//            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setConnectTimeout(5000);
//            //conn.setRequestProperty("content-Ty");
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//            OutputStream os =conn.getOutputStream();
//            os.write(json.getBytes(StandardCharsets.UTF_8));
//            os.close();
//            //read the response
//            InputStream in = new BufferedInputStream(conn.getInputStream());
//            String result = IOUtils.toString(in,"UTF-8");
//            System.out.println(result);
//            System.out.println("Result after response");




    }
}
