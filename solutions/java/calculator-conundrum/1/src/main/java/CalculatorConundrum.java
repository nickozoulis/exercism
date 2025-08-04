class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        try {
            return
                 switch (operation) {
                     case "+" -> calculateAddition(operand1, operand2);
                     case "*" -> calculateMultiplication(operand1, operand2);
                     case "/" -> calculateDivision(operand1, operand2);
                     case "" -> throw new IllegalArgumentException("Operation cannot be empty");
                     default -> throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
                 };
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Operation cannot be null");
        } catch (ArithmeticException e) {
            throw new IllegalOperationException("Division by zero is not allowed", e);
        }
    }

    private String calculateAddition(int operand1, int operand2) {
        return String.format("%d + %d = %d", operand1, operand2, operand1 + operand2);
    }

    private String calculateMultiplication(int operand1, int operand2) {
        return String.format("%d * %d = %d", operand1, operand2, operand1 * operand2);
    }

    private String calculateDivision(int operand1, int operand2) {
        return String.format("%d / %d = %d", operand1, operand2, operand1 / operand2);
    }
}
