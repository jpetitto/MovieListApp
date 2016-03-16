package com.johnpetitto.movielist.details;

import rx.Observable;

public interface DetailsPresenter {
  Observable<MovieDetails> getMovieDetails(int id);
}
