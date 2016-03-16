package com.johnpetitto.movielist.details;

import com.google.gson.annotations.SerializedName;

public class MovieDetails {
  private String overview;
  @SerializedName("release_date") private String releaseDate;
  private int runtime;
  @SerializedName("vote_average") private double voteAverage;
  @SerializedName("vote_count") private int voteCount;
  @SerializedName("imdb_id") private String imdbId;

  public String getOverview() {
    return overview;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public int getRuntime() {
    return runtime;
  }

  public double getVoteAverage() {
    return voteAverage;
  }

  public int getVoteCount() {
    return voteCount;
  }

  public String getImdbId() {
    return imdbId;
  }
}
