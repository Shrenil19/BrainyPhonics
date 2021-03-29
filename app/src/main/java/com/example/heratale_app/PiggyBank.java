package com.example.heratale_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class PiggyBank extends AppCompatActivity {

    private int earned;
    private int spent;
    private int available;

    ImageButton back;
    TextView earned_coins;
    TextView available_coins;
    TextView spent_coins;
    LinearLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piggy_bank);

        back = this.findViewById(R.id.back);
        earned_coins = this.findViewById(R.id.earned_coins);
        available_coins = this.findViewById(R.id.available_coins);
        spent_coins = this.findViewById(R.id.spent_coins);
        table = this.findViewById(R.id.table);

        this.earned = 13; //TODO: set this with JSON data
        this.spent = 0;

        this.available = this.earned - this.spent;

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
        int coins = available;
        // Go through available coins and load pngs based on multiples of 5's, 2's, and 1's
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);

        while (coins / 5 > 0) {
            ImageView stack = new ImageView(this);
            stack.setImageResource(R.drawable.piggybank_stack_gold_coins_5);
            stack.setLayoutParams(layoutParams);
            table.addView(stack);
            coins -= 5;
        }

        while (coins / 2 > 0 ) {
            ImageView gold = new ImageView(this);
            gold.setImageResource(R.drawable.piggybank_gold_coin);
            gold.setLayoutParams(layoutParams);
            table.addView(gold);
            coins -= 2;
        }

        while (coins > 0) {
            ImageView silver = new ImageView(this);
            silver.setImageResource(R.drawable.piggybank_silver_coin);
            silver.setLayoutParams(layoutParams);
            table.addView(silver);
            coins--;
        }
    }


}