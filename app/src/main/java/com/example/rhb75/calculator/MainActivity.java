package com.example.rhb75.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private State state;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset();
    }

    public void onClear(View view) {
        reset();
    }

    public void onDelete(View view) {
        state = state.on_delete(calculator);
        display();
    }

    public void onKey0(View view) {
        state = state.on_input(calculator, "0");
        display();
    }

    public void onKey1(View view) {
        state = state.on_input(calculator, "1");
        display();
    }

    public void onKey2(View view) {
        state = state.on_input(calculator, "2");
        display();
    }

    public void onKey3(View view) {
        state = state.on_input(calculator, "3");
        display();}

    public void onKey4(View view) {
        state = state.on_input(calculator, "4");
        display();}

    public void onKey5(View view) {
        state = state.on_input(calculator, "5");
        display();}

    public void onKey6(View view) {
        state = state.on_input(calculator, "6");
        display();
    }

    public void onKey7(View view) {
        state = state.on_input(calculator, "7");
        display();
    }

    public void onKey8(View view) {
        state = state.on_input(calculator, "8");
        display();
    }

    public void onKey9(View view) {
        state = state.on_input(calculator, "9");
        display();
    }

    public void on_dot(View view) {
        state = state.on_dot(calculator);
        display();
    }

    public void onNegate(View view) {
        state = state.on_negate(calculator);
        display();
    }

    public void onEquals(View view) {
        state = state.on_calculate(calculator, "");
        display();
    }

    public void onAdd(View view) {
        state = state.on_calculate(calculator, "+");
        display();
    }

    public void onSubtract(View view) {
        state = state.on_calculate(calculator, "-");
        display();
    }

    public void onMultiply(View view) {
        state = state.on_calculate(calculator, "*");
        display();
    }

    public void onDivide(View view) {
        state = state.on_calculate(calculator, "/");
        display();
    }

    public void onSquareRoot(View view) {
        state = state.on_sqrt(calculator);
        display();
    }

    private void display() {
        TextView display = findViewById(R.id.displayWindow);
        display.setText(calculator.getBufferAsString());
        TextView history = findViewById(R.id.history);
        history.setText(calculator.getHistory());
    }

    private void reset() {
        state = State.EMPTY;
        calculator = new Calculator();
        display();
    }
}
