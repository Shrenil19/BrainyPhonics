package com.example.heratale_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ContractionsSubsection extends AppCompatActivity {

    String[] lessonstrs = new String[]{
            "Pronoun contractions with am add 'm and contraction with are add 're.", //1
            "Pronoun contractions is add 's.", //2
            "Pronoun contraction with will add 'll.", //3
            "To make a contraction with would just add 'd at the end of the pronoun.", //4
            "Contractions with have add 've.", //5
            "Contractions with not add n't, except for that troublemaker will not which becomes won't.", //5
            "Noun contractions with is add 's.", //6
            "Be careful! Noun contractions with is add 's, but remember that nouns also use 's for a completely different reason, to show possession.", //7
            "" //8
    };
    private TextView lessonstr;
    private ImageButton home;
    private ImageButton quiz;
    private ImageButton check;
    private ImageButton prev;
    private ImageButton next;
    private ImageView imageView0;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imageView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractions_slidedeck);

        lessonstr = findViewById(R.id.lesson);
        imageView0 = findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        System.out.println(lessonstr.getText().toString());
        if (lessonstr.getText().toString() == ("Pronoun contractions with am add 'm and contraction with are add 're.")) {
            System.out.println("hi");
        }
        if (lessonstr.getText().toString().equals("Pronoun contractions with am add 'm and contraction with are add 're.") && RunTimeData.section != 0) {
            updateImages();
        } else {
            System.out.println("not");
        }

        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContractionsSubsection.this, MenuActivity.class));
            }
        });

        quiz = findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContractionsSubsection.this, Quiz.class));
            }
        });

        check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContractionsSubsection.this, ContractionsCheck.class));
            }
        });

        prev = findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RunTimeData.section = (RunTimeData.section - 1) % lessonstrs.length;
                updateImages();
            }
        });

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RunTimeData.section = (RunTimeData.section + 1) % lessonstrs.length;
                updateImages();
            }
        });

    }

    private void updateImages() {
        lessonstr.setText(lessonstrs[RunTimeData.section]);
        int[] resourceId = new int[11];
        int lesson = RunTimeData.section;
        String img_name;
        System.out.println("hey");
        for (int a = 0; a < 11; a++) {
            try {
                img_name = "contractions_" + lesson + "_" + a;
                resourceId[a] = getResources().getIdentifier(img_name, "drawable", getPackageName());
            } catch (Exception e) {
                resourceId[a] = getResources().getIdentifier("screen_background_light","drawable", getPackageName());
            }
            System.out.println(a);
        }
        imageView0.setImageResource(resourceId[0]);
        imageView1.setImageResource(resourceId[1]);
        imageView2.setImageResource(resourceId[2]);
        imageView3.setImageResource(resourceId[3]);
        imageView4.setImageResource(resourceId[4]);
        imageView5.setImageResource(resourceId[5]);
        imageView6.setImageResource(resourceId[6]);
        imageView7.setImageResource(resourceId[7]);
        imageView8.setImageResource(resourceId[8]);
        imageView9.setImageResource(resourceId[9]);
        imageView10.setImageResource(resourceId[10]);
    }
}