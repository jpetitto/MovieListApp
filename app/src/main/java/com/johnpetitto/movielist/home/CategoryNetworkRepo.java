package com.johnpetitto.movielist.home;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;

public class CategoryNetworkRepo {
  private CategoryService service;

  public CategoryNetworkRepo(Retrofit retrofit) {
    service = retrofit.create(CategoryService.class);
  }

  public Observable<Genres> getGenres() {
    return service.getGenres();
  }

  private interface CategoryService {
    @GET("genre/movie/list")
    Observable<Genres> getGenres();
  }
}
