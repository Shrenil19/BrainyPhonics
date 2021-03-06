
package com.example.heratale_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Contractions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contractions_menu);

        ImageButton home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Contractions.this, MenuActivity.class));
            }
        });

        ImageButton check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Contractions.this, ContractionsCheck.class));
            }
        });

        Button m_re = findViewById(R.id.m_re);
        m_re.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                startActivity(new Intent(Contractions.this, ContractionsSubsection.class));
                return false;
            }
        });
    }
}