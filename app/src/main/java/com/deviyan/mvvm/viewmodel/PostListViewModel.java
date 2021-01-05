package com.deviyan.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.deviyan.mvvm.model.PostModel;
import com.deviyan.mvvm.network.APIService;
import com.deviyan.mvvm.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostListViewModel extends ViewModel {

    private MutableLiveData<List<PostModel>> moviesList;

    public PostListViewModel() {
        moviesList = new MutableLiveData<>();
    }

    public MutableLiveData<List<PostModel>> getMoviesListObserver() {
        return moviesList;
    }

    public void makeAPICall(){

        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<PostModel>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                moviesList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                moviesList.postValue(null);
            }
        });

    }

}
