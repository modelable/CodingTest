import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, prices[0]});

        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty()) {
                int[] arr = stack.peek();

                if (arr[1] <= prices[i]) {
                    stack.push(new int[]{i, prices[i]});
                } else {
                    while (!stack.isEmpty() && (stack.peek()[1] > prices[i])) {
                        int[] pop = stack.pop();
                        answer[pop[0]] = i - pop[0];
                    }
                    stack.push(new int[]{i, prices[i]});
                }
            }
        }

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            answer[pop[0]] = prices.length - pop[0] - 1;
        }

        return answer;
    }
}