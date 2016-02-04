package com.johnpetitto.movielist.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CategoryListFragment extends Fragment {
  private String category;

  public static CategoryListFragment newInstance(String category) {
    CategoryListFragment fragment = new CategoryListFragment();
    Bundle bundle = new Bundle(1);
    bundle.putString("category", category);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    category = getArguments().getString("category");
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    TextView textView = new TextView(getActivity());
    textView.setText(category);
    return textView;
  }
}
