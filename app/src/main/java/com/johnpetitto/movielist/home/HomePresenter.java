package com.johnpetitto.movielist.home;

import com.johnpetitto.movielist.movies.Movie;
import rx.Observable;

public interface HomePresenter {
  Observable<Category> getMovieCategories();
  Observable<Movie> getMovies(Category category);
}
