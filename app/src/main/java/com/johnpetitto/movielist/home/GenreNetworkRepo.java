package com.johnpetitto.movielist.home;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public class GenreNetworkRepo {
  private CategoryService service;

  public GenreNetworkRepo(Retrofit retrofit) {
    service = retrofit.create(CategoryService.class);
  }

  public Observable<GenreResponse> getGenres() {
    return service.getGenres();
  }

  public Observable<GenreDiscoverResponse> getMovies(Genre genre) {
    return service.getMovies(genre.getId());
  }

  private interface CategoryService {
    @GET("genre/movie/list")
    Observable<GenreResponse> getGenres();

    @GET("discover/movie")
    Observable<GenreDiscoverResponse> getMovies(@Query("with_genres") int id);
  }
}
