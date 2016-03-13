package com.johnpetitto.movielist.genres;

import com.google.gson.annotations.SerializedName;
import com.johnpetitto.movielist.movies.Movie;
import java.util.List;

public class GenreDiscoverResponse {
  private int page;
  private List<Movie> results;
  @SerializedName("total_pages") private int totalPages;

  public int getPage() {
    return page;
  }

  public List<Movie> getResults() {
    return results;
  }

  public int getTotalPages() {
    return totalPages;
  }
}
