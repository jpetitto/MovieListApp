package com.johnpetitto.movielist.genres;

import com.johnpetitto.movielist.movies.Movie;
import java.util.List;
import rx.Observable;

public interface GenreInteractor {
  Observable<List<Genre>> getGenres();
  Observable<Movie> getMovies(Genre genre);
}
