package Baekjoon;

import java.util.*;

public class G2_1033 {
    static Node[] arr = new Node[11];
    static boolean[] visited = new boolean[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            arr[i] = new Node();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), p = sc.nextInt(), q = sc.nextInt();
            int n1 = p * arr[b].value;
            int n2 = q * arr[a].value;
            int gcd = gcd(n1, n2);
            n1 /= gcd;
            n2 /= gcd;

            update(a, n1);
            update(b, n2);
            visited = new boolean[11];
            arr[a].edge.add(b);
            arr[b].edge.add(a);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i].value + " ");
        }

    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static void update(int index, int n) {
        visited[index] = true;
        arr[index].value *= n;

        for (int e : arr[index].edge) {
            if (visited[e] == false)
                update(e, n);
        }
    }

    static class Node {
        int value;
        ArrayList<Integer> edge;

        Node() {
            this.value = 1;
            this.edge = new ArrayList<Integer>();
        }
    }
}
