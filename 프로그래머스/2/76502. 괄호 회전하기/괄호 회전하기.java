import java.util.*;

class Solution {
    public static int solution(String s) {
        int answer = 0;

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (check(queue.toString())) answer++;
            queue.add(queue.poll());
        }

        return answer;
    }

    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (c == ')') {
                    if (stack.pop() != '(') return false;
                } else if (c == '}') {
                    if (stack.pop() != '{') return false;
                } else if (c == ']') {
                    if (stack.pop() != '[') return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}