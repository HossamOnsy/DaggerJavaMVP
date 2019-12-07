package com.sam.daggerjavamvp.mvp;

import com.sam.daggerjavamvp.model.Cat;

import java.util.List;

public interface MainActivityContract {
    interface View {
        void showCats(List<Cat> data);

        void showError(String message);

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void getCats();
    }
}