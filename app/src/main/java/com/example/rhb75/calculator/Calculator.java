package com.example.rhb75.calculator;

public class Calculator {

    private Buffer displayBuffer;
    private StringBuilder history;
    private double accumulator;
    private String operator;

    public Calculator() {
        displayBuffer = new Buffer();
        history = new StringBuilder("");
        accumulator = 0;
        operator = "";
    }

    public Buffer buffer() {
        return displayBuffer;
    }

    public String getHistory() {
        return history.toString();
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void calculate(String newOperator) {
        updateHistory(newOperator);
        updateResult(operate(accumulator, displayBuffer.asNumber(), operator));
        setOperator(newOperator);
    }

    private void updateResult(double result) {
        if (Double.isInfinite(result) || Double.isNaN(result)) {
            displayBuffer.set("Error");
            accumulator = 0;
        } else {
            displayBuffer.set(result);
            accumulator = result;
        }
    }

    public void sqrt() {
        updateResult(Math.sqrt(displayBuffer.asNumber()));
    }

    private static double operate(double lhs, double rhs, String operator) {
        double result;

        switch (operator) {
            case "+":
                result = lhs + rhs;
                break;

            case "-":
                result = lhs - rhs;
                break;

            case "*":
                result = lhs * rhs;
                break;

            case "/":
                result = lhs / rhs;
                break;

            default:
                result = rhs;
        }

        return result;
    }

    private void updateHistory(String operator) {
        if(operator.isEmpty()) {
            history.setLength(0);
        }
        else {
            history.append(displayBuffer.asString() + " " + operator + " ");
        }
    }
}
