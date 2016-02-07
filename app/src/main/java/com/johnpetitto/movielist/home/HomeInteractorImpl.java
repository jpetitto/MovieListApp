package com.johnpetitto.movielist.home;

import com.johnpetitto.movielist.movies.Movie;
import java.util.List;
import retrofit2.Retrofit;
import rx.Observable;

public class HomeInteractorImpl implements HomeInteractor {
  private Retrofit retrofit;

  public HomeInteractorImpl(Retrofit retrofit) {
    this.retrofit = retrofit;
  }

  @Override public Observable<List<Category>> getMovieCategories() {
    return new CategoryNetworkRepo(retrofit).getGenres().map(Genres::getGenres);
  }

  @Override public Observable<Movie> getMovies(Category category) {
    return null;
  }
}
