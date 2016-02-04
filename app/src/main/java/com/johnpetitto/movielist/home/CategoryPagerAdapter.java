package com.johnpetitto.movielist.home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.johnpetitto.movielist.R;
import java.util.List;

public class CategoryPagerAdapter extends PagerAdapter {
  private Context context;
  private List<Category> categories;

  public CategoryPagerAdapter(Context context, List<Category> categories) {
    this.context = context;
    this.categories = categories;
  }

  @Override public int getCount() {
    return categories.size();
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View layout = inflater.inflate(R.layout.list_category, container, false);
    TextView name = (TextView) layout.findViewById(R.id.name);
    name.setText(categories.get(position).getName());
    container.addView(layout);
    return layout;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override public CharSequence getPageTitle(int position) {
    return categories.get(position).getName();
  }
}
