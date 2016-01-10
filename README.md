# Optimus
===============
- Optimus is a piece-of-cake library containing helper for the shared preferences of Android.

- You should initialize this library inside the onCreate of the Application class of your app.


```Java
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
```


# One-line Usage
