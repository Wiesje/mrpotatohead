package com.example.mrpotatohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> visibleItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            ArrayList<Integer> items = savedInstanceState.getIntegerArrayList("visibleItems");
            android.util.Log.d("potato", "Recovering saved instance state of visibleItems " + visibleItems);
            for (int i = 0; i < items.size(); i++) {
                int resId = items.get(i);
                android.util.Log.d("potato", "Recovering saved instance state of: " + resId);
                android.widget.ImageView image = findViewById(resId);
                image.setVisibility(View.VISIBLE);
                visibleItems.add(resId);
            }
        }
    }

    public void checkClicked(android.view.View v) {
        android.util.Log.d("potato", "checkClicked: ");
        android.widget.CheckBox checkbox = (android.widget.CheckBox) v;
        int resId = getResources().getIdentifier(checkbox.getText().toString(), "id", getPackageName());
        android.widget.ImageView image = findViewById(resId);
        if (checkbox.isChecked()) {
            image.setVisibility(View.VISIBLE);
            visibleItems.add(resId);
        }
        else {
            image.setVisibility(View.INVISIBLE);
            visibleItems.remove(resId);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super
        outState.putIntegerArrayList("visibleItems", visibleItems);

    }
}
