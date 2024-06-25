package Baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;


public class G4_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        long answer = 0;

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        while (!pq.isEmpty()) {
            int a = pq.poll();
            if (pq.isEmpty())
                break;

            int b = pq.poll();
            answer += a + b;
            pq.add(a + b);
        }

        System.out.println(answer);
    }
}