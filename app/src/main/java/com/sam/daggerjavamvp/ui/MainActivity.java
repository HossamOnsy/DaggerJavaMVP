package com.sam.daggerjavamvp.ui;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sam.daggerjavamvp.MyApplication;
import com.sam.daggerjavamvp.R;
import com.sam.daggerjavamvp.di.DaggerMainActivityComponent;
import com.sam.daggerjavamvp.di.components.MainActivityComponent;
import com.sam.daggerjavamvp.di.modules.MainActivityMvpModule;
import com.sam.daggerjavamvp.model.Cat;
import com.sam.daggerjavamvp.mvp.MainActivityContract;
import com.sam.daggerjavamvp.mvp.PresenterImpl;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    MainActivityComponent mainActivityComponent;

    @Inject
    public CatsAdapter catsAdapter;

    @Inject
    PresenterImpl myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectDagger();
        initiateViews();
        initiateCall();

    }

    private void injectDagger() {
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityMvpModule(new MainActivityMvpModule(this))
                .applicationComponent(MyApplication.applicationComponent)
                .build();
        mainActivityComponent.injectMainActivity(this);
    }

    private void initiateViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(catsAdapter);
        progressBar = findViewById(R.id.progressBar);
    }

    private void initiateCall() {
        myPresenter.getCats();
    }


    @Override
    public void showCats(List<Cat> catList) {
        catsAdapter.updateCatList(catList);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
