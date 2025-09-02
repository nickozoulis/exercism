import java.util.*;

class BracketChecker {

    final private String expression;

    private Stack stack = new Stack<String>();

    private final List<String> openings = Arrays.asList("(","[","{");
    private final List<String> closings = Arrays.asList(")","]","}");
    private final Map<String, String> closingMappings = new HashMap<String, String>();

    BracketChecker(String expression) {
        this.expression = expression;
        closingMappings.put(")", "(");
        closingMappings.put("]", "[");
        closingMappings.put("}", "{");
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        if (expression.isEmpty()) return true;
        if (closings.stream().anyMatch(expression::startsWith)) return false;

        expression.chars().forEach( c ->
                processCharacter(String.valueOf((char) c))
        );

        return stack.isEmpty();
    }

    private void processCharacter(String s) {
        if (openings.contains(s)) {
            stack.push(s);
        } else if (closings.contains(s)) {
            if (!stack.isEmpty()) {
                var lastElement = stack.getLast();

                if (lastElement.equals(closingMappings.get(s))) {
                    stack.pop();
                } else {
                    stack.push(s);
                }
            } else {
                stack.push(s);
            }
        }

    }

}