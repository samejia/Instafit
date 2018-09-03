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

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

/*    List<Datum> movieList;
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
    }*/

    Context context;
    private List<Datum> movieList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Datum item);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvOverview,tvReleaseDate;
        ImageView ivMovie;


        public MyViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvOverview = (TextView) v.findViewById(R.id.tvOverView);
            tvReleaseDate = (TextView) v.findViewById(R.id.tvReleaseDate);
            ivMovie = (ImageView) v.findViewById(R.id.ivMovie);

        }

        public void bind(final Datum item, final OnItemClickListener listener) {
            tvTitle.setText(item.getName());
            tvOverview.setText(Html.fromHtml(item.getDescription()));
            tvReleaseDate.setText("Rating "+item.getRating().getRate().toString());
            Glide.with(itemView.getContext()).load(item.getAvatar()).into(ivMovie);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }

    public MoviesAdapter(List<Datum> movieList, Context context, OnItemClickListener listener) {
        this.movieList = movieList;
        this.context = context;
        this.listener = listener;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movies,parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(movieList.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}