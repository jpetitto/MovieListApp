package com.johnpetitto.movielist.movies;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Movie {
  private int id;
  private String overview;
  @SerializedName("release_date") private Date releaseDate;
  @SerializedName("backdrop_path") private String image;
  private double popularity;
  private String title;

  public int getId() {
    return id;
  }

  public String getOverview() {
    return overview;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public double getPopularity() {
    return popularity;
  }

  public String getTitle() {
    return title;
  }
}
