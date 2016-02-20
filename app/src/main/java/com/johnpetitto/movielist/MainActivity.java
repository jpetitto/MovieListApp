package com.johnpetitto.movielist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.johnpetitto.movielist.details.DetailsScreen;
import com.johnpetitto.movielist.home.HomeScreen;

public class MainActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new HomeScreen(this));

    Navigator.getTransitions().subscribe(movie -> setContentView(new DetailsScreen(this, movie)));
  }
}
