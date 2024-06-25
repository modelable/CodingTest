package Baekjoon;

import java.util.Scanner;

public class G1_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        int sqrt_max = (int) Math.sqrt(max);
        boolean[] A = new boolean[sqrt_max + 1];
        boolean[] B = new boolean[(int) (max - min) + 2];

        for (int i = 2; i < A.length; i++) {
            if (A[i] == false) {
                long num;
                long j = (long)i * i;

                if (min % j == 0) { // 시간복잡도를 max - min 범위로 축소
                    num = min / j;
                } else {
                    num = min / j + 1;
                }

                if (num <= max / j) {
                    long l = j * num; // 에라토스테네스의 체 응용

                    while (l <= max) {
                        int index = (int) (l - min) + 1;
                        B[index] = true;
                        if (l > max - j)
                            break;
                        l += j;
                    }
                }
            }
        }
        int count = 0;

        for (int i = 1; i < B.length; i++) {
            if (B[i] == false) {
                count++;
            }
        }
        System.out.println(count);
    }

}
