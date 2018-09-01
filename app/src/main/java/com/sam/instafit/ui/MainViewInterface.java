package com.sam.instafit.ui;

import com.sam.instafit.models.Datum;

public interface MainViewInterface {

    void showToast(String s);
    void displayMovies(Datum movieResponse);
    void displayError(String s);
}