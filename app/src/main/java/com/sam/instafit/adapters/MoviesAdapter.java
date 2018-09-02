package com.sam.instafit.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sam.instafit.R;
import com.sam.instafit.models.Datum;
import com.sam.instafit.models.Result;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {

    List<Datum> movieList;
    Context context;

    public MoviesAdapter(List<Datum> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_movies,parent,false);
        MoviesHolder mh = new MoviesHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {

        holder.tvTitle.setText(movieList.get(position).getName());
        holder.tvOverview.setText(Html.fromHtml(movieList.get(position).getDescription()));
       holder.tvReleaseDate.setText("Rating "+movieList.get(position).getRating().getRate().toString());
      Glide.with(context).load(movieList.get(position).getAvatar()).into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MoviesHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvOverview,tvReleaseDate;
        ImageView ivMovie;

        public MoviesHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvOverview = (TextView) v.findViewById(R.id.tvOverView);
            tvReleaseDate = (TextView) v.findViewById(R.id.tvReleaseDate);
            ivMovie = (ImageView) v.findViewById(R.id.ivMovie);
        }
    }
}