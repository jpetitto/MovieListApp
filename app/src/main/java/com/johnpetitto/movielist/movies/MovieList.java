package com.johnpetitto.movielist.movies;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.johnpetitto.movielist.UiUtils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

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
    movies.observeOn(AndroidSchedulers.mainThread())
        .subscribe(adapter::addMovie, throwable -> UiUtils.showErrorToast(getContext(), throwable));
  }
}
