package co.mobiwise.optimus.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.mobiwise.optimus.Optimus;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Optimus.putInt("saved_number", 10);
    Optimus.putString("saved_text", "not_set_text");
    Optimus.putBoolean("saved_boolean_value", false);
  }
}