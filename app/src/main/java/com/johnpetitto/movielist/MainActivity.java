package com.johnpetitto.movielist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
  @Bind(R.id.toolbar) Toolbar toolbar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    toolbar.inflateMenu(R.menu.main);
    toolbar.setOnMenuItemClickListener(this);

    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.container, new HomeFragment())
        .commit();
  }

  @Override public boolean onMenuItemClick(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_lists:
        Toast.makeText(this, R.string.action_lists, Toast.LENGTH_SHORT).show();
        return true;
      case R.id.action_search:
        Toast.makeText(this, R.string.action_search, Toast.LENGTH_SHORT).show();
        return true;
    }

    return false;
  }
}
