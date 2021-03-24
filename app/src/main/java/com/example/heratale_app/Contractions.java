
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
        ImageButton check = findViewById(R.id.check);
        Button m_re = findViewById(R.id.m_re);
        Button s = findViewById(R.id.s);
        Button ll = findViewById(R.id.ll);
        Button d = findViewById(R.id.d);
        Button ve = findViewById(R.id.ve);
        Button nt = findViewById(R.id.nt);
        Button nouns = findViewById(R.id.nouns);
        Button summary = findViewById(R.id.summary);
        MyTouchListener touch = new MyTouchListener();
        m_re.setOnTouchListener(touch);
        s.setOnTouchListener(touch);
        ll.setOnTouchListener(touch);
        d.setOnTouchListener(touch);
        ve.setOnTouchListener(touch);
        nt.setOnTouchListener(touch);
        nouns.setOnTouchListener(touch);
        summary.setOnTouchListener(touch);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Contractions.this, MenuActivity.class));
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Contractions.this, ContractionsCheck.class));
            }
        });
    }

    public class MyTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (view.getId()) {
                case R.id.m_re:
                    RunTimeData.section = 0;
                    break;

                case R.id.s:
                    RunTimeData.section = 1;
                    break;

                case R.id.ll:
                    RunTimeData.section = 2;
                    break;

                case R.id.d:
                    RunTimeData.section = 3;
                    break;

                case R.id.ve:
                    RunTimeData.section = 4;
                    break;

                case R.id.nt:
                    RunTimeData.section = 5;
                    break;

                case R.id.nouns:
                    RunTimeData.section = 6;
                    break;

                case R.id.summary:
                    RunTimeData.section = 7;
                    break;
            }

            startActivity(new Intent(Contractions.this, ContractionsSubsection.class));
            return false;
        }
    }

}