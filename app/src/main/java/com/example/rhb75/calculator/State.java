package com.example.rhb75.calculator;

public enum State {

    EMPTY {
        @Override
        State on_input(Calculator calculator, String key) {
            calculator.buffer().set(key);
            return APPEND;
        }

        State on_dot(Calculator calculator) {
            calculator.buffer().set("0.");
            return APPEND;
        }

        @Override
        State on_delete(Calculator calculator) {
            calculator.buffer().set("0");
            return this;
        }

        @Override
        State on_negate(Calculator calculator) {
            calculator.buffer().negate();
            return APPEND;
        }

        @Override
        State on_calculate(Calculator calculator, String newOperator) {
            calculator.buffer().normalise();
            calculator.setOperator(newOperator);
            return EMPTY;
        }
        @Override
        State on_sqrt(Calculator calculator) {
            calculator.sqrt();
            return EMPTY;
        }
    },

    APPEND {
        @Override
        State on_input(Calculator calculator, String key) {
            calculator.buffer().push(key);
            return this;
        }

        @Override
        State on_dot(Calculator calculator) {
            calculator.buffer().push(".");
            return this;
        }

        @Override
        State on_delete(Calculator calculator) {
            calculator.buffer().pop();
            return this;
        }

        @Override
        State on_negate(Calculator calculator) {
            calculator.buffer().negate();
            return this;
        }

        @Override
        State on_calculate(Calculator calculator, String newOperator) {
            calculator.calculate(newOperator);
            return FINALISED;
        }

        @Override
        State on_sqrt(Calculator calculator) {
            calculator.sqrt();
            return FINALISED;
        }
    },

    FINALISED {
        @Override
        State on_input(Calculator calculator, String key) {
            calculator.buffer().set(key);
            return APPEND;
        }

        @Override
        State on_dot(Calculator calculator) {
            calculator.buffer().set("0.");
            return APPEND;
        }

        @Override
        State on_delete(Calculator calculator) {
            calculator.buffer().set("0");
            return EMPTY;
        }

        @Override
        State on_negate(Calculator calculator) {
            calculator.buffer().negate();
            return APPEND;
        }

        @Override
        State on_calculate(Calculator calculator, String newOperator) {
            calculator.buffer().normalise();
            calculator.calculate(newOperator);
            return FINALISED;
        }

        @Override
        State on_sqrt(Calculator calculator) {
            calculator.sqrt();
            return FINALISED;
        }
    };

    abstract State on_input(Calculator calculator, String key);

    abstract State on_dot(Calculator calculator);

    abstract State on_delete(Calculator calculator);

    abstract State on_calculate(Calculator calculator, String newOperator);

    abstract State on_negate(Calculator calculator);

    abstract State on_sqrt(Calculator calculator);
}

