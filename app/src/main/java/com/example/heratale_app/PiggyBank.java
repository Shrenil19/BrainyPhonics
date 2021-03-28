package com.example.heratale_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PiggyBank extends AppCompatActivity {

    private int earned;
    private int spent;
    private int available;

    Button back = this.findViewById(R.id.back);
    TextView earned_coins = this.findViewById(R.id.earned_coins);
    TextView available_coins = this.findViewById(R.id.available_coins);
    TextView spent_coins = this.findViewById(R.id.spent_coins);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piggy_bank);

        this.earned = 50; //TODO: set this with JSON data
        this.spent = 10;

        this.available = earned - spent;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setCoinText();
        loadCoins();

    }

    private void setCoinText() {
        earned_coins.setText(Integer.toString(this.earned));
        available_coins.setText(Integer.toString(this.available));
        spent_coins.setText(Integer.toString(this.spent));
    }

    private void loadCoins() {
        // Go through available coins and load pngs based on multiples of 5's, 2's, and 1's
    }


}