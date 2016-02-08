package com.johnpetitto.movielist.home;

import com.johnpetitto.movielist.movies.Movie;
import java.util.List;
import rx.Observable;

public class HomePresenterImpl implements HomePresenter {
  private HomeInteractor interactor;

  public HomePresenterImpl(HomeInteractor interactor) {
    this.interactor = interactor;
  }

  @Override public Observable<List<Genre>> getGenres() {
    return interactor.getGenres();
  }

  @Override public Observable<Movie> getMovies(Genre genre) {
    return interactor.getMovies(genre);
  }
}
