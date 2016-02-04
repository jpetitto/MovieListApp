package com.johnpetitto.movielist.home;

import com.johnpetitto.movielist.movies.Movie;
import rx.Observable;

public class HomePresenterImpl implements HomePresenter {
  @Override public Observable<Category> getMovieCategories() {
    Category[] categories = new Category[] {
        new Category("Drama"),
        new Category("Action"),
        new Category("Comedy"),
        new Category("Horror"),
        new Category("Western")
    };

    return Observable.from(categories);
  }

  @Override public Observable<Movie> getMovies(Category category) {
    Movie[] movies = new Movie[] {
        new Movie("Reservoir Dogs"),
        new Movie("Pulp Fiction"),
        new Movie("Jackie Brown"),
        new Movie("Kill Bill"),
        new Movie("Inglorious Bastards"),
        new Movie("Django Unchained")
    };

    return Observable.from(movies);
  }
}
