package com.johnpetitto.movielist.movies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.johnpetitto.movielist.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
  private List<Movie> movies = new ArrayList<>();

  public void addMovie(Movie movie) {
    movies.add(movie);
    notifyDataSetChanged();
  }

  @Override public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View itemView = inflater.inflate(R.layout.card_movie, parent, false);
    return new MovieViewHolder(itemView);
  }

  @Override public void onBindViewHolder(MovieViewHolder holder, int position) {
    Movie movie = movies.get(position);
    holder.title.setText(movie.getTitle());
    holder.year.setText(getYear(movie.getReleaseDate()));

    Picasso.with(holder.image.getContext())
        .load(movie.getImage())
        .fit()
        .into(holder.image);

    holder.itemView.setOnClickListener(v ->
        Toast.makeText(holder.itemView.getContext(), movie.getTitle(), Toast.LENGTH_SHORT).show());
  }

  @Override public int getItemCount() {
    return movies.size();
  }

  public static class MovieViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.image) ImageView image;
    @Bind(R.id.title) TextView title;
    @Bind(R.id.year) TextView year;

    public MovieViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  // TODO: move this logic out of view
  private String getYear(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return Integer.toString(calendar.get(Calendar.YEAR));
  }
}
