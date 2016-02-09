package com.johnpetitto.movielist.home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.MovieListApp;
import com.johnpetitto.movielist.R;
import java.util.List;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeScreen extends LinearLayout implements HomeView {
  @Bind(R.id.category_tabs) TabLayout categoryTabs;
  @Bind(R.id.category_pager) ViewPager categoryPager;

  private HomePresenter presenter;

  public HomeScreen(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);

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
}
