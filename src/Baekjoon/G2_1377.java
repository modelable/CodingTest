package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class G2_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] A = new Node[N + 1];
        A[0] = new Node(0, 0);

        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(br.readLine());
            A[i] = new Node(i, value);
        }

        Arrays.sort(A, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.value - n2.value;
            }
        });

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (A[i].index - i > answer) {
                answer = A[i].index - i;
            }
        }

        System.out.println(answer + 1);
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            // TODO Auto-generated constructor stub
            this.index = index;
            this.value = value;
        }
    }
}