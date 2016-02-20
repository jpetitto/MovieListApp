package com.johnpetitto.movielist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.details.DetailsScreen;
import com.johnpetitto.movielist.home.HomeScreen;
import com.johnpetitto.movielist.movies.Movie;
import me.mattlogan.library.ViewStack;
import me.mattlogan.library.ViewStackDelegate;

public class MainActivity extends AppCompatActivity implements ViewStackDelegate {
  private static final String VIEW_STACK_TAG = "view_stack";
  private ViewStack viewStack;

  @Bind(R.id.container) FrameLayout container;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    viewStack = ViewStack.create(container, this);

    if (savedInstanceState != null) {
      viewStack.rebuildFromBundle(savedInstanceState, VIEW_STACK_TAG);
    } else {
      viewStack.push(new HomeScreen.Factory());
    }

    Navigator.getTransitions().subscribe(this::showMovieDetails);
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    viewStack.saveToBundle(outState, VIEW_STACK_TAG);
  }

  @Override public void onBackPressed() {
    viewStack.pop();
  }

  @Override public void finishStack() {
    finish();
  }

  private void showMovieDetails(Movie movie) {
    viewStack.push(new DetailsScreen.Factory());
    DetailsScreen detailsScreen = (DetailsScreen) viewStack.peekView();
    detailsScreen.setMovie(movie);
  }
}
