package restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RestAPI extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        //this.getLoggedUser();
        this.login();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private void login(){
        // Creates a reference to CloseableHttpClient, which is thread safe
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpost = new HttpPost("http://localhost/blog/public/api/login");
 
            List params = new ArrayList();
            params.add(new BasicNameValuePair("username", "dalang"));
            params.add(new BasicNameValuePair("password", "password"));
             
            httpost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
             
            //JSONObject responseBody = (JSONObject) httpclient.execute(httpost, responseHandler);

            
            
            
            
            
            CloseableHttpResponse response = httpclient.execute(httpost);
            int status = response.getStatusLine().getStatusCode();
            
            
            
            // Get HttpResponse Status
            System.out.println(response.getProtocolVersion());              // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode());   // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
            System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
            
            
            
            
           
            
//            ResponseHandler<String> responseHandler = new BasicResponseHandler();
//            String responseBody = responseHandler.handleResponse(response);
//            
//            JSONParser parser = new JSONParser();
//            //JSONObject json = new JSONObject();
//            JSONArray json = (JSONArray) parser.parse(responseBody);
//            json.forEach(item ->{
//                JSONObject object = (JSONObject) item;//convert to json object
//                System.out.println(object.get("name"));
//            });
            
            
            
            
            
            
            
            
            
            
//            String statusCode = (String) responseBody.get("status_code");
//            if(statusCode.equalsIgnoreCase("0")){
//                JSONObject data = (JSONObject) responseBody.get("data");
//                token = (String) data.get("token"); // Keep Token for future refferences
//            } 
 
            //System.out.println(responseBody.get("error_message"));
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
//        //Take Input from User for Username and Password
//        String uname = "";
//        String pass = "";
//         
//        String token = "";
//         
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println("Enter Username");
//            uname = br.readLine();
//            System.out.println("Enter Password");
//            pass = br.readLine();
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//        
//         
//        // Creates a reference to CloseableHttpClient, which is thread safe
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        ResponseHandler responseHandler = (ResponseHandler) new MyJSONResponseHandler();
//         
//        try {
//            HttpPost httpost = new HttpPost("http://localhost/blog/public/api/login");
// 
//            List params = new ArrayList();
//            params.add(new BasicNameValuePair("username", uname));
//            params.add(new BasicNameValuePair("password", pass));
//             
//            httpost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
//             
//            JSONObject responseBody = (JSONObject) httpclient.execute(httpost, responseHandler);
//            
//            String statusCode = (String) responseBody.get("status_code");
//            System.out.println(httpclient.execute(httpost, responseHandler));
////            if(statusCode.equalsIgnoreCase("0")){
////                JSONObject data = (JSONObject) responseBody.get("data");
////                token = (String) data.get("token"); // Keep Token for future refferences
////            } 
// 
//            System.out.println(responseBody.get("error_message"));
//        } catch(IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                httpclient.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
    }
    
    
    
    
    private void post(){
        // Creates a reference to CloseableHttpClient, which is thread safe
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpost = new HttpPost("http://localhost/blog/public/api/login");
 
            List params = new ArrayList();
            params.add(new BasicNameValuePair("username", "dalang"));
            params.add(new BasicNameValuePair("password", "password"));
             
            httpost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
            
            
            CloseableHttpResponse response = httpclient.execute(httpost);
            int status = response.getStatusLine().getStatusCode();
            
            
            
            // Get HttpResponse Status
            System.out.println(response.getProtocolVersion());              // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode());   // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
            System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    private void getLoggedUser(){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost/blog/public/api/user");
        request.addHeader(HttpHeaders.ACCEPT, "application/json");//to display response as json
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIyIiwianRpIjoiN2Y5ZmYwMTgyODkzYTI5NGY1YzU1Y2Q2OTA5MzdjMzQwZGE1ZjEzM2YzZWY4NzIzMjA0YWVmNTk4MWRjYjE2NTIwYzIyMzNiZGYwZjJjZWQiLCJpYXQiOjE1OTQ5NzAxMTAsIm5iZiI6MTU5NDk3MDExMCwiZXhwIjoxNjI2NTA2MTA5LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.bdOcd8dbOb1-kHw0CApSfHDJTWQ44cs39rMYzdVb9cRDRyRFQjFrbUycBysBez-u9VhmtW8HGXgfDIwxD2HlTAmzrYX8ruirWFQJv-pCWWDr-cyHmr4SawQFxeJ5_oODB6jOEa3PYDri0tsqktwdT1Pzn5-Q39Ikc419GBHpBicB-pMhCdrnprC7Hn7iNRXbdA4QAQz6ClUMx-OKsSv80mPj8_kP8oRHVKZ9sujorYpLhrkWRtraIiHdAy_uFCdzGzJSU0xaq8J880uxqKoFVhvWLi6mpATX0jEZeRtFcmBb_pzf0Tjfeikm9lfkQcjkAdCBeLc8N8CHPHHa3rwyIHYOfq64KGrKkeaNSN_o5Z0SBbj4AY3TQ8HfwSnJh6XkYt_m1R_BkZCfn2wCjL1Y2YxxGUy-4ErhKF47cgYLeBZFMW1w2oFS1FCquneeqhqDsdqEJl47j9o7xKaWHxBqXXcdegrpngMs_ObCDQ8r2JYJrWa2soeg70t2PswhKBKz2f16uLvteZJTptI1BGSASg6Pq8q33hoiYq55M7ACDeaaEifIpcFC7HuG5I8UUAjingUUJ4oeT93jz1KaTDy4PjHOt4tMqZrZIQjzlfVpxjRTqnGVXvHBD48O1niuF87JyhOTQVLsEukFwtiDL2TMUvWTprL00CEApRAPnDbp0ws";
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        
        CloseableHttpResponse response = null;
        try {
            response = client.execute(request);
            int status = response.getStatusLine().getStatusCode();
 
            if (status >= 200 && status < 300) {
                BufferedReader br;
                 
                br = new BufferedReader(new InputStreamReader(response
                            .getEntity().getContent()));
                 
                String line = "";
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                System.out.println("Unexpected response status: " + status);
            }
        } catch (IOException | UnsupportedOperationException e) {
            e.printStackTrace();
        } finally {
            if(null != response){
                try {
                    response.close();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    
    
    
    
    private void origin(){
        //Take Input from User for Username and Password
        String grantType = "password";
        String clientId = "2";
        String clientSecret = "HsmwCIH8TGprhvgHok2wI9J0GVV2tKguIDB0TcZ4";
        String uname = "ruecker.jovanny@example.org";
        String pass = "password";
         
        String token = "";
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter grant Type");
            grantType = br.readLine();
            System.out.println("Enter client Id");
            clientId = br.readLine();
            System.out.println("Enter client Secret");
            clientSecret = br.readLine();
            System.out.println("Enter Username");
            uname = br.readLine();
            System.out.println("Enter Password");
            pass = br.readLine();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        System.out.println(br);
         
         
        // Creates a reference to CloseableHttpClient, which is thread safe
        CloseableHttpClient httpclient = HttpClients.createDefault();

        ResponseHandler responseHandler = (ResponseHandler) new MyJSONResponseHandler();
         
        try {
            HttpPost httpost = new HttpPost("http://localhost/blog/public/oauth/token");
            httpost.addHeader(HttpHeaders.ACCEPT, "application/json");
                    
//            List params = new ArrayList();
//            params.add(new BasicNameValuePair("grant_type", grantType));
//            params.add(new BasicNameValuePair("client_id", clientId));
//            params.add(new BasicNameValuePair("client_secret", clientSecret));
//            params.add(new BasicNameValuePair("username", uname));
//            params.add(new BasicNameValuePair("password", pass));
//             
            //httpost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
             
            JSONObject responseBody = (JSONObject) httpclient.execute(httpost, responseHandler);
            String statusCode = (String) responseBody.get("status_code");
            if(statusCode.equalsIgnoreCase("0")){
                JSONObject data = (JSONObject) responseBody.get("data");
                token = (String) data.get("token"); // Keep Token for future refferences
            } 
 
            System.out.println(responseBody.get("error_message"));
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
