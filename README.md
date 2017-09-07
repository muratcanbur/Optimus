# Optimus

- Optimus is a piece-of-cake library containing helper for the shared preferences of Android.

- You should initialize this library inside the onCreate of the Application class of your app.

## Getting Started

Step 1. Add the JitPack repository to your build file.

## Gradle ##
```
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

Step 2 . Add the dependency.
```
dependencies {
  compile 'com.github.muratcanbur:Optimus:0.0.1'
}
```

## initialization
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

```Java
   Optimus.putInt("saved_int_value", 10);
   Optimus.putString("saved__string_value", "Calling all Autobots");
   Optimus.putBoolean("saved_boolean_value", true);
```

## Read from Shared Preferences

```Java
    Optimus.getBoolean("saved_boolean_value",false);   
    Optimus.getString("saved__string_value", "default__string_value");
    Optimus.getInt("saved_int_value",0);
```
  
Things TODO
-----------
You can contribute.

* [ ] Save ArrayList to SharedPreferences.
* [ ] Save List of Object to SharedPreferences.

License
--------


    Copyright 2016 muratcanbur.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
