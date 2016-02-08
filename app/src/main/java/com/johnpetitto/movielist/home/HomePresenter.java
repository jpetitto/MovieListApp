package com.johnpetitto.movielist.home;

import com.johnpetitto.movielist.movies.Movie;
import java.util.List;
import rx.Observable;

public interface HomePresenter {
  Observable<List<Genre>> getGenres();
  Observable<Movie> getMovies(Genre genre);
}
