package com.example.rhb75.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private State state;
    StringBuilder current;
    private double accumulator;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset();
    }

    public void on_C(View view) {
        reset();
    }

    public void on_del(View view) {
        if(current.length() > 0 ) {
            current.deleteCharAt(current.length() - 1);
        }
        display();
    }

    public void on_0(View view) {
        state = state.on_input(current, "0");
        display();
    }

    public void on_1(View view) {
        state = state.on_input(current, "1");
        display();
    }

    public void on_2(View view) {
        state = state.on_input(current, "2");
        display();
    }

    public void on_3(View view) {
        state = state.on_input(current, "3");
        display();}

    public void on_4(View view) {
        state = state.on_input(current, "4");
        display();}

    public void on_5(View view) {
        state = state.on_input(current, "5");
        display();}

    public void on_6(View view) {
        state = state.on_input(current, "6");
        display();
    }

    public void on_7(View view) {
        state = state.on_input(current, "7");
        display();
    }

    public void on_8(View view) {
        state = state.on_input(current, "8");
        display();
    }

    public void on_9(View view) {
        state = state.on_input(current, "9");
        display();
    }

    public void on_dot(View view) {
        state = state.on_dot(current);
        display();
    }

    public void on_negate(View view) {
        state = state.on_negate(current);
        display();
    }

    public void on_equals(View view) {
        state = state.on_calculate(current,
                                   accumulator,
                                   operator);
        display();
    }

    public void on_add(View view) {
        accumulator = Manipulators.to_number(current.toString());
        operator = "+";
        state = state.on_operator();
        display();
    }

    public void on_subtract(View view) {
        accumulator = Manipulators.to_number(current.toString());
        operator = "-";
        state = state.on_operator();
        display();
    }

    public void on_multiply(View view) {
        accumulator = Manipulators.to_number(current.toString());
        operator = "*";
        state = state.on_operator();
        display();
    }

    public void on_divide(View view) {
        accumulator = Manipulators.to_number(current.toString());
        operator = "/";
        state = state.on_operator();
        display();
    }

    private void display() {
        TextView textView = findViewById(R.id.displayWindow);
        textView.setText(current.toString());
    }

    private void reset() {
        state = State.EMPTY;
        accumulator = 0;
        operator = "";
        current = new StringBuilder("0");
        display();
    }
}
