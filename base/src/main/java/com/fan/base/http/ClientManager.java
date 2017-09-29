package com.fan.base.http;

import java.util.HashMap;
import java.util.Map;


public class ClientManager {
    private static Map<String, RetrofitClient> clientMap = new HashMap<>();

    private ClientManager() {
    }

    public static RetrofitClient getClient(String url) {
        RetrofitClient appClient;
        appClient = clientMap.get(url);

        if (appClient == null) {
            try {
                appClient = new RetrofitClient(url);
            } catch (Exception e) {
                appClient = new RetrofitClient();
                url = RetrofitClient.URL_BASE;
                e.printStackTrace();
            }
            clientMap.put(url, appClient);
        }

        return appClient;
    }

    public static RetrofitClient getClient() {
        return getClient(RetrofitClient.URL_BASE);
    }

    public static void registerClient(String url) {
        if (!clientMap.containsKey(url)) {
            RetrofitClient client = new RetrofitClient(url);
            clientMap.put(url, client);
        }
    }
}
