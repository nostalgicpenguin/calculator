package com.example.rhb75.calculator;

public enum State {

    EMPTY {
        @Override
        State on_input(Calculator calculator, String key) {
            calculator.setBuffer(key);
            return APPEND;
        }

        State on_dot(Calculator calculator) {
            calculator.setBuffer("0.");
            return APPEND;
        }

        @Override
        State on_delete(Calculator calculator) {
            calculator.setBuffer("0");
            return this;
        }

        @Override
        State on_negate(Calculator calculator) {
            calculator.negateBuffer();
            return APPEND;
        }

        @Override
        State on_calculate(Calculator calculator, String newOperator) {
            calculator.normaliseBuffer();
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
            calculator.pushBuffer(key);
            return this;
        }

        @Override
        State on_dot(Calculator calculator) {
            calculator.pushBuffer(".");
            return this;
        }

        @Override
        State on_delete(Calculator calculator) {
            calculator.popBuffer();
            return this;
        }

        @Override
        State on_negate(Calculator calculator) {
            calculator.negateBuffer();
            return this;
        }

        @Override
        State on_calculate(Calculator calculator, String newOperator) {
            calculator.updateHistory(newOperator);
            calculator.calculate();
            calculator.setOperator(newOperator);
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
            calculator.setBuffer(key);
            return APPEND;
        }

        @Override
        State on_dot(Calculator calculator) {
            calculator.setBuffer("0.");
            return APPEND;
        }

        @Override
        State on_delete(Calculator calculator) {
            calculator.setBuffer("0");
            return EMPTY;
        }

        @Override
        State on_negate(Calculator calculator) {
            calculator.negateBuffer();
            return APPEND;
        }

        @Override
        State on_calculate(Calculator calculator, String newOperator) {
            calculator.normaliseBuffer();
            calculator.updateHistory(newOperator);
            calculator.calculate();
            calculator.setOperator(newOperator);
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

