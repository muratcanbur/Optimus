package co.mobiwise.optimus.example;

import android.app.Application;

import co.mobiwise.optimus.Optimus;

public class OptimusApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize Optimus class
    new Optimus.Fabricate()
        .setContext(this)
        .setPrefsName(getPackageName())
        .fabricate();

    StethoUtil.init(this);
  }
}