package com.deviyan.mvvm.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//call for network library
public class RetroInstance {

    public static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit;

    public static Retrofit getRetroClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
