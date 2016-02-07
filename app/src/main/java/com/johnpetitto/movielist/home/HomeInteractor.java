package com.johnpetitto.movielist.home;

import com.johnpetitto.movielist.movies.Movie;
import java.util.List;
import rx.Observable;

public interface HomeInteractor {
  Observable<List<Category>> getMovieCategories();
  Observable<Movie> getMovies(Category category);
}
