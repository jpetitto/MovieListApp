package com.johnpetitto.movielist.details;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.R;
import com.johnpetitto.movielist.movies.Movie;
import com.squareup.picasso.Picasso;

public class DetailsScreen extends FrameLayout {
  @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;
  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.backdrop) ImageView backdrop;

  private Movie movie;

  public DetailsScreen(Context context, Movie movie) {
    super(context);
    this.movie = movie;
    init();
  }

  public DetailsScreen(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    inflate(getContext(), R.layout.details_movie, this);
    ButterKnife.bind(this);

    collapsingToolbar.setTitle(movie.getTitle());
    Picasso.with(getContext()).load(movie.getImage()).into(backdrop);
  }
}
