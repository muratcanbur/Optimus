package co.mobiwise.optimus.example;

import android.app.Application;
import android.content.ContextWrapper;

import co.mobiwise.optimus.Optimus;

public class OptimusApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize Optimus class
    new Optimus.Fabricate()
        .setContext(this)
        .setMode(ContextWrapper.MODE_PRIVATE)
        .setPrefsName(getPackageName())
        .fabricate();

    StethoUtil.init(this);
  }
}