package co.mobiwise.optimus.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import co.mobiwise.optimus.Optimus;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Optimus.putInt("saved_int_value", 10);
    Optimus.putString("saved__string_value", "Calling all Autobots");
    Optimus.putBoolean("saved_boolean_value", true);
  }
}