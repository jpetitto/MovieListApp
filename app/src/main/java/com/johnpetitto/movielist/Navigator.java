package com.johnpetitto.movielist;

import com.johnpetitto.movielist.movies.Movie;
import rx.Observable;
import rx.subjects.PublishSubject;

public class Navigator {
  private static PublishSubject<Movie> subject = PublishSubject.create();

  public static void setTransition(Movie movie) {
    subject.onNext(movie);
  }

  public static Observable<Movie> getTransitions() {
    return subject.asObservable();
  }
}
