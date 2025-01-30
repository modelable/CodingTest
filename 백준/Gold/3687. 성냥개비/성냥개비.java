import java.io.*;
import java.util.*;

public class Main {

    private static String[] max;
    private static String[] min;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        max = new String[101];
        min = new String[101];
        init();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            System.out.println(min[n] + " " + max[n]);
        }
    }

    public static void init() {
        StringBuilder sb;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 6); map.put(1, 2); map.put(2, 5); map.put(3, 5); map.put(4, 4);
        map.put(5, 5); map.put(6, 6); map.put(7, 3); map.put(8, 7); map.put(9, 6);

        //가장 큰 수를 위한 로직
        for (int i = 2; i <= 100; i++) {
            sb = new StringBuilder();

            if (i % 2 == 0) {
                for (int j = 0; j < i / 2; j++) {
                    sb.append("1");
                }
            } else {
                sb.append("7");
                for (int j = 0; j < i / 2 - 1; j++) {
                    sb.append("1");
                }
            }
            max[i] = sb.toString();
            //System.out.print(max[i] + " ");
        }

        //가장 작은 수를 위한 로직
        for (int i = 2; i <= 100; i++) {
            sb = new StringBuilder();
            int num = i;
            int digit = (i - 1) / 7 + 1;
            //자릿수: (i - 1) / 7 + 1
            for (int j = digit; j >= 1; j--) {
                for (int k = 0; k <= 9; k++) {
                    if (j == digit && k == 0) continue;

                    if (j == 1) {
                        if (map.get(k) == num) {
                            sb.append(k);
                            break;
                        }
                    } else {
                        if (num - map.get(k) <= 7 * (j - 1)) {
                            num -= map.get(k);
                            sb.append(k);
                            break;
                        }
                    }
                }
            }
            min[i] = sb.toString();
        }
    }
}