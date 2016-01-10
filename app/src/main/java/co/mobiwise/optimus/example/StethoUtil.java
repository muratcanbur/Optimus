package co.mobiwise.optimus.example;

import android.content.Context;

import com.facebook.stetho.Stetho;

public final class StethoUtil {

  private static boolean INIT = false;

  private StethoUtil() {
  }

  public static void init(Context context) {
    Stetho.initialize(
        Stetho.newInitializerBuilder(context)
            .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
            .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
            .build());
    INIT = true;
  }
}
