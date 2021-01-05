package com.deviyan.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.deviyan.mvvm.adapter.PostListAdapter;
import com.deviyan.mvvm.model.PostModel;
import com.deviyan.mvvm.viewmodel.PostListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMoviesList;
    private PostListAdapter postListAdapter;
    private List<PostModel> postModelList;
    private PostListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMoviesList = (RecyclerView)findViewById(R.id.rv_movies_list);
        final TextView noresult = findViewById(R.id.tv_no_result);

        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvMoviesList.setLayoutManager(layoutManager);
        postListAdapter = new PostListAdapter(this, postModelList);
        rvMoviesList.setAdapter(postListAdapter);

        viewModel = ViewModelProviders.of(this).get(PostListViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                if(postModels != null) {
                    postModelList = postModels;
                    postListAdapter.setPostModels(postModels);
                    noresult.setVisibility(View.GONE);
                } else {
                    noresult.setVisibility(View.VISIBLE);
                }
            }
        });

        viewModel.makeAPICall();
    }
}