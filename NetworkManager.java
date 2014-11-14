package com.free.retrofitex;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

import javax.xml.ws.Response;

/**
 * Created by free on 14.11.14.
 */
public class NetworkManager {

    public static final String CHECK_LOGIN_ACTION = "checkLogin";
    public static final String ADD_USER_ACTION = "addUser";

    private RestAdapter restAdapter;
    RetroAPI retroAPI;

    public NetworkManager() {

        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint(BuildConfig.API_SERVER);
        restAdapter = builder.build();
        retroAPI = restAdapter.create(RetroAPI.class);
    }

    /**
     * Asynchronously checks existence user with this login
     * <p/>
     * {api_server}?action={action}&login={login}
     *
     */
    public String getRequest() {
        return  retroAPI.getRequest();
    }

    public interface RetroAPI {


        @GET("/public/yql?q=select%20rate%2Cname%20from%20csv%20where%20url%3D'http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes%3Fs%3DUSDCHF%253DX%26f%3Dl1n'%20and%20columns%3D'rate%2Cname'&format=json")
        String getRequest();

    }

}
