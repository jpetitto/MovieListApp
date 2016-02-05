package com.johnpetitto.movielist.movies;

import rx.Observable;

public interface MovieView {
  void addMovies(Observable<Movie> movies);
}
