package com.johnpetitto.movielist;

import android.content.Context;
import android.widget.Toast;

public final class UiUtils {
  private UiUtils() {}

  public static void showErrorToast(Context context, Throwable throwable) {
    Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
  }
}
