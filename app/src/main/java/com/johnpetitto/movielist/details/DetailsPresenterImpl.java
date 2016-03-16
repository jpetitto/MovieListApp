package com.johnpetitto.movielist.details;

import rx.Observable;

public class DetailsPresenterImpl implements DetailsPresenter {
  DetailsInteractor interactor;

  public DetailsPresenterImpl(DetailsInteractor interactor) {
    this.interactor = interactor;
  }

  @Override public Observable<MovieDetails> getMovieDetails(int id) {
    return interactor.getMovieDetails(id);
  }
}
