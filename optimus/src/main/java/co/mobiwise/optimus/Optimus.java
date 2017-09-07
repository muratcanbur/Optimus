package co.mobiwise.optimus;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.util.HashSet;

public final class Optimus {

  private static SharedPreferences preferences;

  /**
   * Initialize Optimus helper class
   */
  private static void init(Context context, String prefsName, int mode) {
    preferences = context.getSharedPreferences(prefsName, mode);
  }

  /**
   * Returns the SharedPreference instance
   */
  public static SharedPreferences getOptimusPref() {
    if (preferences != null) {
      return preferences;
    } else {
      throw new RuntimeException("You should initialize Optimus inside onCreate of the Application class");
    }
  }

  /**
   * retrieves a stored boolean value.
   */
  public static boolean getBoolean(final String key, final boolean defaultValue) {
    return getOptimusPref().getBoolean(key, defaultValue);
  }

  /**
   * stores a boolean value.
   */
  public static void putBoolean(final String key, final boolean value) {
    final Editor editor = getOptimusPref().edit();
    editor.putBoolean(key, value).apply();
  }

  /**
   * stores an integer value.
   */
  public static void putInt(final String key, final int value) {
    final Editor editor = getOptimusPref().edit();
    editor.putInt(key, value).apply();
  }

  /**
   * retrieves a stored int value.
   */
  public static int getInt(final String key, int defaultValue) {
    return getOptimusPref().getInt(key, defaultValue);
  }

  /**
   * retrieves a stored String value.
   */
  public static String getString(final String key, final String defaultValue) {
    return getOptimusPref().getString(key, defaultValue);
  }

  /**
   * stores a string value.
   */
  public static void putString(final String key, final String value) {
    final Editor editor = getOptimusPref().edit();
    editor.putString(key, value).apply();
  }

  /**
   * retrieves a stored Long value.
   */
  public static long getLong(final String key, final long defValue) {
    return getOptimusPref().getLong(key, defValue);
  }

  /**
   * stores a long value.
   */
  public static void putLong(final String key, final long value) {
    final Editor editor = getOptimusPref().edit();
    editor.putLong(key, value);
    editor.apply();
  }

  /**
   * retrieves a stored float value.
   */
  public static float getFloat(final String key, final float defValue) {
    return getOptimusPref().getFloat(key, defValue);
  }

  /**
   * stores a float value.
   */
  public static void putFloat(final String key, final float value) {
    final Editor editor = getOptimusPref().edit();
    editor.putFloat(key, value).apply();
  }

  /**
   * retrieves a stored double value.
   * <p>
   * The correct way of dealing with this is to convert the double to its 'raw long bits' equivalent and store that long.
   * When we're reading the value, we just convert back to double.
   */
  public static double getDouble(final String key, final double defaultValue) {
    return Double.longBitsToDouble(getOptimusPref().getLong(key, Double.doubleToLongBits(defaultValue)));
  }

  /**
   * stores a double value.
   * The correct way of dealing with this is to convert the double to its 'raw long bits' equivalent and store that long
   */
  public static void putDouble(final String key, final double value) {
    final Editor editor = getOptimusPref().edit();
    editor.putLong(key, Double.doubleToRawLongBits(value)).apply();
  }

  /**
   * Removes a preference value.
   */
  public static void remove(final String key) {
    SharedPreferences prefs = getOptimusPref();
    final Editor editor = prefs.edit();
    editor.remove(key).apply();
  }

  /**
   * stores a string SET value
   */
  public static void putStringSet(String key, HashSet<String> value) {
    final Editor editor = getOptimusPref().edit();
    editor.putStringSet(key, value);
  }

  /**
   * retrieves a string SET value
   */
  public static HashSet<String> getStringSet(String key, HashSet<String> defaultValue) {
    return (HashSet<String>) getOptimusPref().getStringSet(key, defaultValue);
  }

  /**
   * Removed all the stored keys and values.
   */
  public static Editor removeAll() {
    final Editor editor = getOptimusPref().edit().clear();
    editor.apply();
  }

  /**
   * checks whether a value is stored for the given key.
   */
  public static boolean contains(final String key) {
    return getOptimusPref().contains(key);
  }

  /**
   * returns the Editor of SharedPreferences instance.
   */
  public static Editor getEditor() {
    return getOptimusPref().edit();
  }
  
  public static void putStringListWithName(String key, List<String> list){
    Gson gson = new Gson();
    editor.putString(key, gson.toJson(list));
  }

  public static List<String> getStringListWithName(String key, List<String> list){
    Type type = new TypeToken<List<String>>(){}.getType();
    List<String> stringList = gson.fromJson(getOptimusPref().getString(key, defaultValue), type);
    return stringList;
  }

  /**
   * This is a builder class for the Optimus instance.
   */
  public static class Fabricate {

    private String prefsName;
    private Context context;
    private int mode = ContextWrapper.MODE_PRIVATE;

    /**
     * the application's packagename should be the filename of the SharedPreference instance
     */
    public Fabricate setPrefsName(final String prefsName) {
      this.prefsName = prefsName;
      return this;
    }

    /**
     * in Android world, always we need to have this context
     */
    public Fabricate setContext(final Context context) {
      this.context = context;
      return this;
    }

    public void fabricate() {
      if (context == null) {
        throw new RuntimeException("Context not set");
      }

      if (TextUtils.isEmpty(prefsName)) {
        prefsName = context.getPackageName();
      }
      Optimus.init(context, prefsName, mode);
    }
  }
}
