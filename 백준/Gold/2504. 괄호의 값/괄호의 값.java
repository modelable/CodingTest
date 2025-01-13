import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0, temp = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i - 1) == ')' || str.charAt(i - 1) == ']') {
                    temp /= 2;
                    continue;
                }
                answer += temp;
                temp /= 2;
            } else {
                if (stack.isEmpty() || stack.pop() != '[') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i - 1) == ')' || str.charAt(i - 1) == ']') {
                    temp /= 3;
                    continue;
                }
                answer += temp;
                temp /= 3;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}