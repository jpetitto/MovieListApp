package com.johnpetitto.movielist.genres;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.johnpetitto.movielist.R;
import com.johnpetitto.movielist.movies.MovieList;
import java.util.List;

public class GenrePagerAdapter extends PagerAdapter {
  private GenrePresenter presenter;
  private List<Genre> genres;

  public GenrePagerAdapter(GenrePresenter presenter, List<Genre> genres) {
    this.presenter = presenter;
    this.genres = genres;
  }

  @Override public int getCount() {
    return genres.size();
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    LayoutInflater inflater = LayoutInflater.from(container.getContext());
    MovieList movieList = (MovieList) inflater.inflate(R.layout.list_movie, container, false);
    container.addView(movieList);

    movieList.addMovies(presenter.getMovies(genres.get(position)));

    return movieList;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override public CharSequence getPageTitle(int position) {
    return genres.get(position).getName();
  }
}
