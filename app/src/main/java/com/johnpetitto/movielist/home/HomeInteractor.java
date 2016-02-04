package com.johnpetitto.movielist.home;

import com.johnpetitto.movielist.movies.Movie;
import rx.Observable;

public interface HomeInteractor {
  Observable<Category> getMovieCategories();
  Observable<Movie> getMovies(Category category);
}
