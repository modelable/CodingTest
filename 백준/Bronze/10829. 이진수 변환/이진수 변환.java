import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long num = scanner.nextLong();
        Stack<Integer> stack = new Stack<>();

        while (num > 1) {
            stack.push((int)(num % 2));
            num /= 2;
        }
        stack.push(1);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}