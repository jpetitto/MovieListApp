package com.johnpetitto.movielist.home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.MovieListApp;
import com.johnpetitto.movielist.R;
import java.util.List;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeScreen extends FrameLayout implements HomeView, Toolbar.OnMenuItemClickListener {
  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.category_tabs) TabLayout categoryTabs;
  @Bind(R.id.category_pager) ViewPager categoryPager;

  private HomePresenter presenter;

  public HomeScreen(Context context) {
    super(context);
    init();
  }

  public HomeScreen(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    inflate(getContext(), R.layout.screen_home, this);
    ButterKnife.bind(this);

    toolbar.inflateMenu(R.menu.main);
    toolbar.setOnMenuItemClickListener(this);

    MovieListApp app = (MovieListApp) getContext().getApplicationContext();
    Retrofit retrofit = app.getRetrofitInstance();
    HomeInteractor interactor = new HomeInteractorImpl(retrofit);
    presenter = new HomePresenterImpl(interactor);

    presenter.getGenres()
        .subscribeOn(Schedulers.io())
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
