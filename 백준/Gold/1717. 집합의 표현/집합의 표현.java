import java.util.*;

public class Main {

    private static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            int op = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (op == 0) {
                union(a, b);
            } else if (op == 1) {
                if (find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    public static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
}