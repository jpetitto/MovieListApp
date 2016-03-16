package com.johnpetitto.movielist.details;

import rx.Observable;

public interface DetailsInteractor {
  Observable<MovieDetails> getMovieDetails(int id);
}
