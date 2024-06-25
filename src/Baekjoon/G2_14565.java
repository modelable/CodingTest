package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class G2_14565 {
    static Stack<Long> qStack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong(), A = sc.nextLong();
        System.out.print(N - A + " ");
        long gcd = gcd(A, N);
        if (gcd != 1) {
            System.out.println(-1);
        } else {
            long eea = eea(1, 0);

            while (eea <= 0) {
                eea += N;
            }

            System.out.println(eea);
        }
    }

    static long gcd(long a, long b) {
        long q = a / b; // 몫
        qStack.push(q);

        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }

    static long eea(long x, long y) {
        if (qStack.isEmpty()) {
            return x;
        }

        long q = qStack.pop();
        long X = y, Y = x - y * q;
        return eea(X, Y);
    }
}
