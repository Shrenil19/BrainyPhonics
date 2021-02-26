package com.example.heratale_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.heratale_app.json.JsonHelper;

public class TestJsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_json);

        JsonHelper helper = new JsonHelper("test1", this);
        TextView text = findViewById(R.id.textView);
        Log.d("text", text.toString());
        Log.d("helper", helper.readFocusItem(1));

        text.setText(helper.readFocusItem(1));
    }
}