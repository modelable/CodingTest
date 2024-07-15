import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, prices[0]});

        for (int i = 0; i < prices.length; i++) {
            int size = prices.length;
            int[] answer = new int[size];
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{0, prices[0]});

            for (int i = 1; i < size; i++) {
                while (!stack.isEmpty() && (stack.peek()[1] > prices[i])) {
                    int[] pop = stack.pop();
                    answer[pop[0]] = i - pop[0];
                }
                stack.push(new int[]{i, prices[i]});
            }

            while (!stack.isEmpty()) {
                int[] pop = stack.pop();
                answer[pop[0]] = size - pop[0] - 1;
            }

            return answer;
        }

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            answer[pop[0]] = prices.length - pop[0] - 1;
        }

        return answer;
    }
}