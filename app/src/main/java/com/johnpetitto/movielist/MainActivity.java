package com.johnpetitto.movielist;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.home.Category;
import com.johnpetitto.movielist.home.CategoryPagerAdapter;
import com.johnpetitto.movielist.home.HomePresenter;
import com.johnpetitto.movielist.home.HomePresenterImpl;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
  @Bind(R.id.category_tabs) TabLayout categoryTabs;
  @Bind(R.id.category_pager) ViewPager categoryPager;

  private HomePresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    if (getSupportActionBar() != null) {
      getSupportActionBar().setElevation(0);
    }

    presenter = new HomePresenterImpl();

    presenter.getMovieCategories()
        .toList()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::initTabs);
  }

  private void initTabs(List<Category> categories) {
    categoryPager.setAdapter(new CategoryPagerAdapter(this, categories));
    categoryTabs.setupWithViewPager(categoryPager);
  }
}
