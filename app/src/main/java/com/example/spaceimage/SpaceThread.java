package com.example.spaceimage;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SpaceThread extends Thread {
    Handler handler;
    OkHttpClient okHttpClient;
    public SpaceThread(Handler handler){
        this.handler = handler;
        okHttpClient = new OkHttpClient();
    }

    @Override
    public void run() {
        super.run();
        String address = "https://api.nasa.gov/planetary/apod";
        HttpUrl.Builder urlBuilder = HttpUrl.parse(address).newBuilder();
        urlBuilder.addQueryParameter("api_key", "DEMO_KEY");
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            String respStr = "";
            Response response = okHttpClient.newCall(request).execute();
            if(response.code() == 200){
                respStr = response.body().string();
            }else {
                //TODO что сообщить, если произошла ошибка
                respStr = "Ошибка соединения: " + response.code();
            };
            Message message = new Message();
            message.obj = respStr;
            handler.sendMessage(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
