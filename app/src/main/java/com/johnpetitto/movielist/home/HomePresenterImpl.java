package com.johnpetitto.movielist.home;

import com.johnpetitto.movielist.movies.Movie;
import java.util.List;
import rx.Observable;

public class HomePresenterImpl implements HomePresenter {
  private HomeInteractor interactor;

  public HomePresenterImpl(HomeInteractor interactor) {
    this.interactor = interactor;
  }

  @Override public Observable<List<Category>> getMovieCategories() {
    return interactor.getMovieCategories();
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
