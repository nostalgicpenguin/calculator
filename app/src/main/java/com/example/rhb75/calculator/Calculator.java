package com.example.rhb75.calculator;

public class Calculator {

    private StringBuilder buffer;
    private StringBuilder history;
    private double accumulator;
    private String operator;

    public Calculator() {
        buffer = new StringBuilder("0");
        history = new StringBuilder("");
        accumulator = 0;
        operator = "";
    }

    public void setBuffer(String value) {
        buffer.setLength(0);
        if( !value.isEmpty() ) {
            buffer.append(value);
        }
    }

    public void setBuffer(double value) {
        buffer.setLength(0);
        buffer.append(to_string(value));
    }

    public void popBuffer() {
        if(buffer.length() > 0 ) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public void pushBuffer(String next) {
        if(is_or_could_be_a_number(buffer.toString() + next)) {
            buffer.append(next);
        }
    }

    public void negateBuffer() {
        if(buffer.toString().startsWith("-")) {
            buffer.deleteCharAt(0);
        }
        else {
            if(buffer.toString().equals("0")) {
                buffer.setLength(0);
            }
            buffer.insert(0, "-");
        }
    }

    public void normaliseBuffer() {
        setBuffer(getBufferAsNumber());
    }

    public double getBufferAsNumber() {
        return to_number(buffer.toString());
    }

    public String getBufferAsString() {
        return buffer.toString();
    }

    public String getHistory() {
        return history.toString();
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void calculate() {
        double lhs = accumulator;
        double rhs = getBufferAsNumber();
        double result;

        history.append(" ");
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

        if (Double.isInfinite(result)) {
            setBuffer("Error");
            accumulator = 0;
        } else {
            setBuffer(result);
            accumulator = result;
        }
    }

    public void updateHistory(String operator) {
        if(operator.isEmpty()) {
            history.setLength(0);
        }
        else {
            history.append(getBufferAsString() + " " + operator + " ");
        }
    }

    public void sqrt() {
        double result = Math.sqrt(getBufferAsNumber());
        if( result == Double.NaN ) {
            setBuffer("Error");
        } else {
            setBuffer(result);
        }
    }

    private static String to_string(double input) {
        //If it's actually an integer (and not too big), return that
        if (input < Integer.MAX_VALUE && input > Integer.MIN_VALUE && Math.ceil(input) == input) {
            return Integer.toString((int)input);
        }
        else {
            return Double.toString(input);
        }
    }

    private static double to_number(String input) {
        try {
            return Double.parseDouble(input);
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }

    private static boolean is_or_could_be_a_number(String number_to_test) {
        try {
            // Append a zero, in case it ends with a decimal point
            Double.parseDouble(number_to_test + "0");
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
