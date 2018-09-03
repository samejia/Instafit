package com.sam.instafit.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.sam.instafit.R;
import com.sam.instafit.adapters.MoviesAdapter;
import com.sam.instafit.models.Datum;
import com.sam.instafit.models.Result;
import com.sam.instafit.ui.Views.MainViewInterface;
import com.sam.instafit.ui.Presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;

    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;
    //RecyclerView rvMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //rvMovies = (RecyclerView) findViewById(R.id.rvMovies);

        setupMVP();
        setupViews();
        getMovieList();
    }



    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews(){
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getMovieList() {

        mainPresenter.getMovies();

    }



    @Override
    public void showToast(String str) {
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayMovies(Result movieResponse) {
        if(movieResponse!=null) {
            Log.d(TAG,movieResponse.getData().get(0).getName());
            /*adapter = new MoviesAdapter(movieResponse.getData(), MainActivity.this);*/
            rvMovies.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            /*rvMovies.setAdapter(adapter);*/
            rvMovies.setAdapter(new MoviesAdapter(movieResponse.getData(), MainActivity.this, new MoviesAdapter.OnItemClickListener() {
                @Override public void onItemClick(Datum item) {
                    Intent i = new Intent(MainActivity.this, DetalleActivity.class);
                    i.putExtra("album", item);
                    startActivity(i);
                   /* Toast.makeText(MainActivity.this,
                            "Funciona", Toast.LENGTH_LONG).show();*/
                }
            }));
        }else{
            Log.d(TAG,"Response null");
        }
    }

    @Override
    public void displayError(String e) {

        showToast(e);

    }

}