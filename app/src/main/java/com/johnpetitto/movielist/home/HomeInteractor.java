package com.johnpetitto.movielist.home;

import rx.Observable;

public interface HomeInteractor {
  Observable<Category> getMovieCategories();
  Observable<Movie> getMovies(Category category);
}
