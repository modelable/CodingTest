import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('(', 0); priority.put(')', 0);
        priority.put('+', 1); priority.put('-', 1);
        priority.put('*', 2); priority.put('/', 2);

        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == ')') {
                while (stack.peek() != '(') {
                    System.out.print(stack.pop());
                }
                stack.pop(); //'('
            } else if (ch == '(') {
                stack.push(ch);
            } else if (priority.containsKey(ch)) { //연산자이면
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(ch))
                        System.out.print(stack.pop());
                    stack.push(ch);
                }
            } else { //피연산자이면
                System.out.print(ch);
            }
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop());
    }
}