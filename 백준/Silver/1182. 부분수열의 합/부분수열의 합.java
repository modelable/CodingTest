import java.util.*;

public class Main {

    private static int answer, N, S;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        answer = 0;
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        backtrack(1000001, 0);

        System.out.println(answer);
    }

    public static void backtrack(int sum, int index) {
        if (sum == S) answer++;
        if (sum == 1000001) sum = 0;

        for (int i = index; i < N; i++) {
            if (arr[i] > 0 && sum + arr[i] > S) continue;
            else backtrack(sum + arr[i], i + 1);
        }
    }
}
