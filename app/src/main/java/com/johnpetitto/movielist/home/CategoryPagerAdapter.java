package com.johnpetitto.movielist.home;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.johnpetitto.movielist.R;
import com.johnpetitto.movielist.movies.MovieList;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CategoryPagerAdapter extends PagerAdapter {
  private HomePresenter presenter;
  private List<Category> categories;

  public CategoryPagerAdapter(HomePresenter presenter, List<Category> categories) {
    this.presenter = presenter;
    this.categories = categories;
  }

  @Override public int getCount() {
    return categories.size();
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    LayoutInflater inflater = LayoutInflater.from(container.getContext());
    MovieList movieList = (MovieList) inflater.inflate(R.layout.list_movie, container, false);
    container.addView(movieList);

    presenter.getMovies(categories.get(position))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(movieList::addMovie);

    return movieList;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override public CharSequence getPageTitle(int position) {
    return categories.get(position).getName();
  }
}
