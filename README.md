# Optimus

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

# Single-line Usage

## Write to Shared Preferences

-    Optimus.putInt("saved_int_value", 10);
-    Optimus.putString("saved__string_value", "Calling all Autobots");
-    Optimus.putBoolean("saved_boolean_value", true);


## Read from Shared Preferences

-   Optimus.getBoolean("saved_boolean_value",false);
-   Optimus.getString("saved__string_value", "default__string_value");
-   Optimus.getInt("saved_int_value",0);
