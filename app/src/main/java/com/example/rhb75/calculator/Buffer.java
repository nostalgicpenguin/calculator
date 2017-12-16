package com.example.rhb75.calculator;

public class Buffer {
    private StringBuilder buffer;

    public Buffer() {
        buffer = new StringBuilder("0");
    }

    public void set(String value) {
        buffer.setLength(0);
        if( !value.isEmpty() ) {
            buffer.append(value);
        }
    }

    public void set(double value) {
        buffer.setLength(0);
        buffer.append(convertToString(value));
    }

    public void pop() {
        if(buffer.length() > 0 ) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public void push(String next) {
        if(is_or_could_be_a_number(buffer.toString() + next)) {
            buffer.append(next);
        }
    }

    public void negate() {
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

    public void normalise() {
        set(asNumber());
    }

    public double asNumber() {
        try {
            return Double.parseDouble(buffer.toString());
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }

    public String asString() {
        return buffer.toString();
    }

    private static String convertToString(double input) {
        // If it's actually an integer (and not too big), return that
        if (input < Integer.MAX_VALUE && input > Integer.MIN_VALUE && Math.ceil(input) == input) {
            return Integer.toString((int)input);
        }
        else {
            return Double.toString(input);
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
