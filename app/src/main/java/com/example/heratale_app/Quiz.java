package com.example.heratale_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import android.widget.Toast;
import com.example.heratale_app.json.JsonHelper;
import android.os.Handler;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private ImageButton sendData;
    private TextView question;
    private ImageView stars;
    private int correct = 0;
    private int currentQuestionIdx = 0;
    private int programID = 69;
    private static Context context;
    private int seconds = 0;
    private int tries = 0;
    private boolean running;

    private JsonHelper dataHelper;

    private Question[] questionBank = new Question[] {
            new Question("I'm", "that's", "we'd", "where's", Answer.ONE),
            new Question("they'd", "I'm", "we'd", "where's", Answer.TWO),
            new Question("I'm", "who's", "we'd", "where's", Answer.ONE),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getApplicationContext();
        dataHelper = new JsonHelper("test1", Quiz.context);
        setContentView(R.layout.quiz);
        option1 = findViewById(R.id.button1);
        option2 = findViewById(R.id.button2);
        option3 = findViewById(R.id.button3);
        option4 = findViewById(R.id.button4);
        sendData = findViewById(R.id.testSendDataButton);
        question = findViewById(R.id.question);
        stars = findViewById(R.id.stars);
        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        sendData.setOnClickListener(this);
        if (!running) {
            seconds = 0;
            running = true;
            runTimer();
        }
        updateQuestion();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button1:
                checkAnswer(Answer.ONE);
                break;

            case R.id.button2:
                checkAnswer(Answer.TWO);
                break;

            case R.id.button3:
                checkAnswer(Answer.THREE);
                break;

            case R.id.button4:
                checkAnswer(Answer.FOUR);
                break;

            case R.id.testSendDataButton:
                dataHelper.sendFocusItem(1, 30, "5c1c3e5b2cd7cdda36e3fa57");
                startActivity(new Intent(Quiz.this, ContractionsCheck.class));
                break;

            case R.id.bank:
                System.out.println("trying");
                startActivity(new Intent(Quiz.this, PiggyBank.class));
                break;
        }
    }

    private void checkAnswer(Answer chosen) {
        Answer answer = questionBank[currentQuestionIdx].getAnswer();
        System.out.println(seconds);
        tries++;
        if (chosen == answer) {
            correct++;
            currentQuestionIdx = (currentQuestionIdx + 1) % (questionBank.length - 1);
            dataHelper.sendFocusItem(tries, seconds, "fake"); // need to change focusID
            seconds = 0;
            tries = 0;
            updateQuestion();
        }
    }

    private void updateQuestion() {
        option1.setText(questionBank[currentQuestionIdx].getOption1());
        option2.setText(questionBank[currentQuestionIdx].getOption2());
        option3.setText(questionBank[currentQuestionIdx].getOption3());
        option4.setText(questionBank[currentQuestionIdx].getOption4());

        int num_stars = correct;
        if (correct < 5) {
            num_stars = 5;
        }
        String img_name =  "stars" + Integer.toString(num_stars);
        int resourceId = getResources().getIdentifier(img_name, "drawable", getPackageName());
        stars.setImageResource(resourceId);
    }

    private void runTimer() {
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            public void run() {
                seconds++;
                handler.postDelayed(this, 1000);
            }
        });
    }

}
