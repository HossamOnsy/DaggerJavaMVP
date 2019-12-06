package com.sam.daggerjavamvp;


import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sam.daggerjavamvp.model.Cat;
import com.sam.daggerjavamvp.network.APIInterface;
import com.sam.daggerjavamvp.network.RetrofitModule;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import static com.sam.daggerjavamvp.network.NetworkUtils.createWebService;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    APIInterface apiInterface;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    public RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiateViews();
        intiateComponentsForNetworkCall();
        intiateCall();

    }

    private void initiateViews() {
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);
        progressBar = findViewById(R.id.progressBar);

    }

    private void intiateComponentsForNetworkCall() {
        apiInterface = createWebService();
    }

    private void intiateCall() {

        apiInterface.getCats(30).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Cat>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Cat> cats) {
                        recyclerViewAdapter.setData(cats);
                        Log.e("LOGCHECK","cats.size -> " + cats.size());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void launchIntent(String name) {

    }
}
