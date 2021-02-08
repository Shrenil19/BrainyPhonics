package com.example.heratale_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WordStructuresMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_structures_main);

        Button contractions_slidedeck = findViewById(R.id.button7);
        contractions_slidedeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WordStructuresMainActivity.this, Contractions.class));
            }
        });
    }


}