package com.johnpetitto.movielist;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.johnpetitto.movielist.network.ApiKeyInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class MovieListApp extends Application {
  private Retrofit retrofit;

  @Override public void onCreate() {
    super.onCreate();
    Timber.plant(new Timber.DebugTree());

    String apiKey = getResources().getString(R.string.movie_db_key);

    OkHttpClient httpClient = new OkHttpClient.Builder()
        .addInterceptor(new ApiKeyInterceptor(apiKey))
        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build();

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    retrofit = new Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
  }

  public Retrofit getRetrofitInstance() {
    return retrofit;
  }
}
