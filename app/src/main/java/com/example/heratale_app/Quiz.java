package com.example.heratale_app;

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

    private JsonHelper dataHelper = new JsonHelper("test1", this);

    private Question[] questionBank = new Question[] {
            new Question("I'm", "that's", "we'd", "where's", Answer.ONE),
            new Question("they'd", "I'm", "we'd", "where's", Answer.TWO),
            new Question("I'm", "who's", "we'd", "where's", Answer.ONE),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                startActivity(new Intent(Quiz.this, Contractions.class));
                break;
        }
    }

    private void checkAnswer(Answer chosen) {
        Answer answer = questionBank[currentQuestionIdx].getAnswer();

        if (chosen == answer) {
            correct++;
            currentQuestionIdx = (currentQuestionIdx + 1) % (questionBank.length - 1);
            updateQuestion();
        }
    }

    private void updateQuestion() {
        option1.setText(questionBank[currentQuestionIdx].getOption1());
        option2.setText(questionBank[currentQuestionIdx].getOption2());
        option3.setText(questionBank[currentQuestionIdx].getOption3());
        option4.setText(questionBank[currentQuestionIdx].getOption4());

        switch(correct) {
            case 0:
                stars.setImageResource(R.drawable.zero_stars);
                break;

            case 1:
                stars.setImageResource(R.drawable.one_star);
                break;

            case 2:
                stars.setImageResource(R.drawable.two_stars);
                break;

            case 3:
                stars.setImageResource(R.drawable.three_stars);
                break;

            case 4:
                stars.setImageResource(R.drawable.four_stars);
                break;

            case 5:
                stars.setImageResource(R.drawable.five_stars);
                break;

        }

    }

}
