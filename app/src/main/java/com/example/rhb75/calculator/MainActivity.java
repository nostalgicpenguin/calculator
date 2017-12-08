package com.example.rhb75.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on_0(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "0"));
    }

    public void on_1(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "1"));
    }

    public void on_2(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "2"));
    }

    public void on_3(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "3"));
    }

    public void on_4(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "4"));
    }

    public void on_5(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "5"));
    }

    public void on_6(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "6"));
    }

    public void on_7(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "7"));
    }

    public void on_8(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "8"));
    }

    public void on_9(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "9"));
    }

    public void on_dot(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(append(textView.getText().toString(), "."));
    }

    public void on_plus_minus(View view) {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(negate(textView.getText().toString()));
    }

    private String append(String current, String next) {
        try {
            Float.parseFloat(current + next + "0");
            return current + next;
        }
        catch (NumberFormatException e) {
            return current;
        }
    }

    private String negate(String current) {
        if(current.equals("")) {
            return current;
        }

        if(current.startsWith("-")) {
            return current.substring(1);
        }
        else {
            return "-" + current;
        }
    }
}
