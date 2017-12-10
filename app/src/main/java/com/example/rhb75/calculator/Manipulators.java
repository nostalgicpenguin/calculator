package com.example.rhb75.calculator;

public class Manipulators {

    public static boolean is_or_could_be_a_number(String number_to_test) {
        try {
            // Append a zero, in case it ends with a decimal point
            Double.parseDouble(number_to_test + "0");
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static void append(StringBuilder current, String next) {
        if(is_or_could_be_a_number(current.toString() + next)) {
            current.append(next);
        }
    }

    public static void negate(StringBuilder current) {
        if(current.toString().startsWith("-")) {
            current.deleteCharAt(0);
        }
        else {
            current.insert(0, "-");
        }
    }

    public static double to_number(String input) {
        try {
            return Double.parseDouble(input);
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String to_string(double input) {
        // If it's actually an integer, return that
        if (Math.ceil(input) == input) {
            return Integer.toString((int)input);
        }
        else {
            return Double.toString(input);
        }
    }
}
