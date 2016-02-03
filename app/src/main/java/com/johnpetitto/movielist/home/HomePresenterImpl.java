package com.johnpetitto.movielist.home;

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
    return null;
  }
}
