package com.sam.instafit.ui.Views;


import com.sam.instafit.database.DatabaseHandler;
import com.sam.instafit.models.FavoriteInst;


public interface DetallePresenter {
    void attachDB(DatabaseHandler db);
    boolean addToFavorite(FavoriteInst artist);

}
