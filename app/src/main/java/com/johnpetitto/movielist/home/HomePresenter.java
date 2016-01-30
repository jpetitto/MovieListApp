package com.johnpetitto.movielist.home;

import rx.Observable;

public interface HomePresenter {
  Observable<Category> getMovieCategories();
  Observable<Movie> getMovies(Category category);
}
