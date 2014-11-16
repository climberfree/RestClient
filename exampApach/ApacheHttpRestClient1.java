package com.free.retrofitex.exampApach;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by free on 14.11.14.
 */
public class ApacheHttpRestClient1 {

    private DefaultHttpClient httpclient = new DefaultHttpClient();
    // specify the host, protocol, and port
    HttpHost target = new HttpHost("query.yahooapis.com", 80, "http");

    public static void main(String[] args) {
        ApacheHttpRestClient1 apacheHttpRestClient1=new ApacheHttpRestClient1();
        apacheHttpRestClient1.getRate("USDRUB");
    }

    private double getRate(String currenceName)
    {
        double rate = 0;
        try {

            HttpGet getRequest = new HttpGet
                    ("/v1/public/yql?q=select%20rate%2Cname%20from%20csv%20where%20url%3D'http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes%3Fs%3D"+currenceName+"%253DX%26f%3Dl1n'%20and%20columns%3D'rate%2Cname'&format=json");

            HttpResponse httpResponse = httpclient.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();
            System.out.println("----------------------------------------");
            System.out.println(httpResponse.getStatusLine());

            if (entity != null) {
                JSONObject jsonObj = new JSONObject(EntityUtils.toString(entity));
                JSONObject query= (JSONObject) jsonObj.get("query");
                JSONObject result= (JSONObject) query.get("results");
                JSONObject row= (JSONObject) result.get("row");
                rate= Double.parseDouble((String) row.get("rate"));

                System.out.println("ndgkjb "+rate);
                System.out.println("query " + jsonObj.toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
        return rate;
    }
}
