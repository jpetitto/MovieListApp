package com.johnpetitto.movielist.genres;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.MovieListApp;
import com.johnpetitto.movielist.R;
import java.util.List;
import me.mattlogan.library.ViewFactory;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;

public class GenreScreen extends LinearLayout implements GenreView, Toolbar.OnMenuItemClickListener {
  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.category_tabs) TabLayout categoryTabs;
  @Bind(R.id.category_pager) ViewPager categoryPager;

  private GenrePresenter presenter;

  public static class Factory implements ViewFactory {
    @Override public View createView(Context context, ViewGroup container) {
      return LayoutInflater.from(context).inflate(R.layout.screen_home, container, false);
    }
  }

  public GenreScreen(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);

    toolbar.inflateMenu(R.menu.main);
    toolbar.setOnMenuItemClickListener(this);

    MovieListApp app = (MovieListApp) getContext().getApplicationContext();
    Retrofit retrofit = app.getRetrofitInstance();
    GenreInteractor interactor = new GenreInteractorImpl(retrofit);
    presenter = new GenrePresenterImpl(interactor);

    presenter.getGenres()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::initTabs);
  }

  private void initTabs(List<Genre> genres) {
    categoryPager.setAdapter(new GenrePagerAdapter(presenter, genres));
    categoryTabs.setupWithViewPager(categoryPager);
  }

  @Override public boolean onMenuItemClick(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_lists:
        Toast.makeText(getContext(), R.string.action_lists, Toast.LENGTH_SHORT).show();
        return true;
      case R.id.action_search:
        Toast.makeText(getContext(), R.string.action_search, Toast.LENGTH_SHORT).show();
        return true;
    }

    return false;
  }
}
