package com.example.rhb75.calculator;

public enum State {

    EMPTY {
        @Override
        State on_input(StringBuilder current, String key) {
            current.setLength(0);
            current.append(key);
            return APPEND;
        }

        State on_dot(StringBuilder current) {
            current.setLength(0);
            current.append("0.");
            return APPEND;
        }

        @Override
        State on_negate(StringBuilder current) {
            current.setLength(0);
            current.append("-");
            return APPEND;
        }

        @Override
        State on_calculate(StringBuilder current, double accumulator, String operator) {
            String currentBuffer = Manipulators.to_string(Manipulators.to_number(current.toString()));
            current.setLength(0);
            current.append(currentBuffer);
            return EMPTY;
        }

    },
    APPEND {
        @Override
        State on_input(StringBuilder current, String key) {
            Manipulators.append(current, key);
            return this;
        }

        @Override
        State on_dot(StringBuilder current) {
            Manipulators.append(current, ".");
            return this;
        }

        @Override
        State on_negate(StringBuilder current) {
            Manipulators.negate(current);
            return this;
        }

        @Override
        State on_calculate(StringBuilder current, double lhs, String operator) {
            double rhs = Manipulators.to_number(current.toString());
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

            current.setLength(0);
            if (Double.isInfinite(result)) {
                current.append("Error");
            } else {
                current.append(Manipulators.to_string(result));
            }

            return EMPTY;
        }
    };

    abstract State on_input(StringBuilder current, String key);

    abstract State on_dot(StringBuilder current);

    abstract State on_calculate(StringBuilder current, double accumulator, String operator);

    abstract State on_negate(StringBuilder current);
}

