import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<Integer> queue = new ArrayDeque<>();

        // O(N): 큐 초기화
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // O(N*K): 로직 실행
        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }

        System.out.println(sb.substring(0, sb.length() - 2) + ">");
    }
}