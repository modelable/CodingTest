import java.math.BigInteger;
import java.util.*;

public class Main {
    private static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        sb = new StringBuilder();

        BigInteger base = BigInteger.valueOf(2);
        sb.append(base.pow(n).subtract(new BigInteger("1")) + "\n");

        if (n <= 20) f(n, 1, 3, 2);

        System.out.print(sb);
    }

    public static void f(int k, int from, int to, int stay) {
        if (k <= 0) return;

        f(k-1, from, stay, to);
        sb.append(from + " " + to + "\n");
        f(k-1, stay, to, from);
    }
}