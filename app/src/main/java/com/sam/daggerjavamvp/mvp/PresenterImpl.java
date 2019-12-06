package com.sam.daggerjavamvp.mvp;

import com.sam.daggerjavamvp.model.Cat;
import com.sam.daggerjavamvp.network.ApiServiceInterface;

import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.sam.daggerjavamvp.network.NetworkUtils.createWebService;

public class PresenterImpl implements MainActivityContract.Presenter {

    ApiServiceInterface apiServiceInterface = createWebService();
    MainActivityContract.View mView;

    public PresenterImpl(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getCats() {
        mView.showProgress();

        apiServiceInterface.getCats(30).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Cat>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mView.showProgress();
                    }
                    @Override
                    public void onNext(List<Cat> cats) {
                        mView.showCats(cats);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mView.hideProgress();
                    }
                });
    }
}

