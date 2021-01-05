package com.deviyan.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deviyan.mvvm.R;
import com.deviyan.mvvm.model.PostModel;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {

    private Context context;
    private List<PostModel> postModels;

    public PostListAdapter(Context context, List<PostModel> postModels) {
        this.context = context;
        this.postModels = postModels;
    }

    //in case the data are not passing to constructor
    //we set in explicitly
    public void setPostModels(List<PostModel> postModels){
        this.postModels = postModels;
        notifyDataSetChanged(); // refresh always listview in the recyclerview
    }

    @NonNull
    @Override
    public PostListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate row movies item
        View view = LayoutInflater.from(context).inflate(R.layout.row_movies_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostListAdapter.ViewHolder holder, int position) {

        String title = (this.postModels.get(position).getTitle());
        String user_id = postModels.get(position).getUserId();
        String id = postModels.get(position).getId();

        holder.tvTitle.setText("title: " + title);
        holder.tvUserId.setText("user_id:  " + user_id);
        holder.tvId.setText("id " + id);


//        holder.tvUserId.setText(this.movieModels.get(position).getUserId());
//        holder.tvId.setText(this.movieModels.get(position).getId());

//        Glide.with(context)
//                .load(this.movieModels.get(position).getImage())
//                .apply(RequestOptions.centerCropTransform())
//                .into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
       if(this.postModels != null){
           return this.postModels.size();
       }
       return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle, tvId, tvUserId;

        //ImageView ivMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvId = itemView.findViewById(R.id.tv_id);
            tvUserId = itemView.findViewById(R.id.tv_user_id);
            //ivMovie = itemView.findViewById(R.id.iv_movie);

        }
    }

}
