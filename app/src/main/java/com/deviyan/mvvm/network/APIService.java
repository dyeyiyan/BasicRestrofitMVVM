package com.deviyan.mvvm.network;


import com.deviyan.mvvm.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//making the api call through retrofit
public interface APIService {

    @GET("albums")
    Call<List<PostModel>> getMovieList();


}
