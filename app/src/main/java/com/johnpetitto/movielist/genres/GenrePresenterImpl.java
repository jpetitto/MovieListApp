package com.johnpetitto.movielist.genres;

import com.johnpetitto.movielist.movies.Movie;
import java.util.List;
import rx.Observable;

public class GenrePresenterImpl implements GenrePresenter {
  private GenreInteractor interactor;

  public GenrePresenterImpl(GenreInteractor interactor) {
    this.interactor = interactor;
  }

  @Override public Observable<List<Genre>> getGenres() {
    return interactor.getGenres();
  }

  @Override public Observable<Movie> getMovies(Genre genre) {
    return interactor.getMovies(genre);
  }
}
