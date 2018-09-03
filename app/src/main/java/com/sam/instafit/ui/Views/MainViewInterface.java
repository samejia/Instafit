package com.sam.instafit.ui.Views;

import com.sam.instafit.models.Result;

public interface MainViewInterface {

    void showToast(String s);
    void displayMovies(Result movieResponse);
    void displayError(String s);
}