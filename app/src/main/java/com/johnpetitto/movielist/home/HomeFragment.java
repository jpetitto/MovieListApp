package com.johnpetitto.movielist.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.MovieListApp;
import com.johnpetitto.movielist.R;
import java.util.List;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeFragment extends Fragment implements HomeView {
  @Bind(R.id.category_tabs) TabLayout categoryTabs;
  @Bind(R.id.category_pager) ViewPager categoryPager;

  private HomePresenter presenter;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.screen_home, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Retrofit retrofit = ((MovieListApp) getActivity().getApplication()).getRetrofitInstance();
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
