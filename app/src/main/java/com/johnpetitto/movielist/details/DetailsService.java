package com.johnpetitto.movielist.details;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface DetailsService {
  @GET("movie/{id}") Observable<MovieDetails> getMovieDetails(@Path("id") int id);
}
