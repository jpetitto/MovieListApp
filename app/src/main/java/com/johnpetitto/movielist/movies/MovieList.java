package com.johnpetitto.movielist.movies;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class MovieList extends RecyclerView {
  public MovieList(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();

    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    setLayoutManager(layoutManager);

    MovieListAdapter adapter = new MovieListAdapter();
    setAdapter(adapter);
  }

  public void addMovie(Movie movie) {
    ((MovieListAdapter) getAdapter()).addMovie(movie);
  }
}
