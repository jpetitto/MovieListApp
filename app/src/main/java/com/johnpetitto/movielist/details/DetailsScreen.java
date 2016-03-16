package com.johnpetitto.movielist.details;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.MovieListApp;
import com.johnpetitto.movielist.R;
import com.johnpetitto.movielist.movies.Movie;
import com.squareup.picasso.Picasso;
import icepick.Icepick;
import icepick.State;
import me.mattlogan.library.ViewFactory;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailsScreen extends CoordinatorLayout {
  @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;
  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.backdrop) ImageView backdrop;
  @Bind(R.id.movie_details) TextView movieDetails;

  @State String movieTitle;
  @State String movieImage;

  private DetailsPresenter presenter;

  public static class Factory implements ViewFactory {
    @Override public View createView(Context context, ViewGroup container) {
      return LayoutInflater.from(context).inflate(R.layout.details_movie, container, false);
    }
  }

  public DetailsScreen(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected Parcelable onSaveInstanceState() {
    return Icepick.saveInstanceState(this, super.onSaveInstanceState());
  }

  @Override protected void onRestoreInstanceState(Parcelable state) {
    super.onRestoreInstanceState(Icepick.restoreInstanceState(this, state));
    init();
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);

    toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
    toolbar.setNavigationOnClickListener(v -> ((Activity) getContext()).onBackPressed());

    MovieListApp app = (MovieListApp) getContext().getApplicationContext();
    Retrofit retrofit = app.getRetrofitInstance();
    DetailsInteractor interactor = new DetailsInteractorImpl(retrofit);
    presenter = new DetailsPresenterImpl(interactor);
  }

  public void setMovie(Movie movie) {
    this.movieTitle = movie.getTitle();
    this.movieImage = movie.getImage();
    init();

    presenter.getMovieDetails(movie.getId())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::showMovieDetails);
  }

  private void init() {
    toolbar.setTitle(movieTitle);
    Picasso.with(getContext()).load(movieImage).into(backdrop);
  }

  private void showMovieDetails(MovieDetails details) {
    movieDetails.setText(details.getOverview());
  }
}
