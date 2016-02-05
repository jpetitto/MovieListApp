package com.johnpetitto.movielist.movies;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MovieList extends RecyclerView implements MovieView {
  private MovieListAdapter adapter;

  public MovieList(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();

    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    setLayoutManager(layoutManager);

    adapter = new MovieListAdapter();
    setAdapter(adapter);
  }

  @Override public void addMovies(Observable<Movie> movies) {
    movies.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(adapter::addMovie);
  }
}
