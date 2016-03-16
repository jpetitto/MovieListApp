package com.johnpetitto.movielist.details;

import retrofit2.Retrofit;
import rx.Observable;

public class DetailsInteractorImpl implements DetailsInteractor {
  private DetailsService service;

  public DetailsInteractorImpl(Retrofit retrofit) {
    service = retrofit.create(DetailsService.class);
  }

  @Override public Observable<MovieDetails> getMovieDetails(int id) {
    return service.getMovieDetails(id);
  }
}
