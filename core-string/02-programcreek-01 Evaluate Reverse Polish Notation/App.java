import java.util.Stack;

public class App {
    public static void main(String[] args) {
        String [] tokens = new String[] {"2", "1", "-", "3", "*"};
        System.out.println(Solution.evalRPN(tokens));
    }
}

class Solution {
    public static int evalRPN(String[] tokens) {
        Integer result = 0;
        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            switch(token) {
            case "+":
                if (!stack.isEmpty()) {
                    Integer temp = Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop());
                    stack.push(temp.toString());
                }
            break;
            case "-":
                if (!stack.isEmpty()) {
                    Integer temp = Integer.valueOf(stack.pop()) - Integer.valueOf(stack.pop());
                    stack.push(temp.toString());
                }
            break;
            case "*":
                if (!stack.isEmpty()) {
                    Integer temp = Integer.valueOf(stack.pop()) * Integer.valueOf(stack.pop());
                    stack.push(temp.toString());
                }
            break;
            case "/":
                if (!stack.isEmpty()) {
                    Integer temp = Integer.valueOf(stack.pop()) / Integer.valueOf(stack.pop());
                    stack.push(temp.toString());
                }
            break;
            default:
                stack.push(token);
            }
        }

        result = Integer.valueOf(stack.pop());
        return result;
    }
}