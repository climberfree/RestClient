package com.free.retrofitex;

import com.free.retrofitex.NetworkManager;

/**
 * Created by free on 14.11.14.
 */
public class Main {
    public static void main(String[] args) {

        NetworkManager networkManager = new NetworkManager();
        String response = networkManager.getRequest();
        System.out.println("response = "+response);
    }
}
