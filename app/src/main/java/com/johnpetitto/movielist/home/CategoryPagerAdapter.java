package com.johnpetitto.movielist.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

public class CategoryPagerAdapter extends FragmentStatePagerAdapter {
  private List<Category> categories;

  public CategoryPagerAdapter(FragmentManager fm, List<Category> categories) {
    super(fm);
    this.categories = categories;
  }

  @Override public Fragment getItem(int position) {
    return CategoryListFragment.newInstance(categories.get(position).getName());
  }

  @Override public int getCount() {
    return categories.size();
  }

  @Override public CharSequence getPageTitle(int position) {
    return categories.get(position).getName();
  }
}
