import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();

        // O(N): queue 초기화
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new int[]{progresses[i], speeds[i]});
        }

        // O(N^2): 기능 개발
        while (!queue.isEmpty()) {
            if (queue.peek()[0] < 100) {
                for (int i = 0; i < queue.size(); i++) {
                    int[] poll = queue.poll();
                    queue.add(new int[]{poll[0] + poll[1], poll[1]});
                }
            } else {
                int count = 0;
                while(!queue.isEmpty() && queue.peek()[0] >= 100) {
                    queue.poll();
                    count++;
                }
                list.add(count);
            }
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}