package com.sam.instafit.ui.Presenter;


import com.sam.instafit.database.DatabaseHandler;
import com.sam.instafit.models.FavoriteInst;
import com.sam.instafit.ui.Views.DetallePresenter;
import com.sam.instafit.ui.Views.DetalleView;


public class DetallePresenterImpl implements DetallePresenter {
    DetalleView view;
    DatabaseHandler db;



    @Override
    public void attachDB(DatabaseHandler db) {
        this.db = db;
    }

    @Override
    public boolean addToFavorite(FavoriteInst artist) {
        db.addFavoriteInstruc(artist);
        return true;
    }

}
