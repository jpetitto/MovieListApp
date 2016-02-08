package com.johnpetitto.movielist.home;

import com.johnpetitto.movielist.movies.Movie;
import java.util.List;
import retrofit2.Retrofit;
import rx.Observable;

public class HomeInteractorImpl implements HomeInteractor {
  private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

  private Retrofit retrofit;

  public HomeInteractorImpl(Retrofit retrofit) {
    this.retrofit = retrofit;
  }

  @Override public Observable<List<Genre>> getGenres() {
    return new GenreNetworkRepo(retrofit).getGenres().map(GenreResponse::getGenres);
  }

  @Override public Observable<Movie> getMovies(Genre genre) {
    return new GenreNetworkRepo(retrofit)
        .getMovies(genre)
        .map(GenreDiscoverResponse::getResults)
        .flatMap(Observable::from)
        .doOnNext(movie -> movie.setImage(IMAGE_BASE_URL + movie.getImage()));
  }
}
