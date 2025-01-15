import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static PriorityQueue<Integer> pq1;
    private static PriorityQueue<Integer> pq2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); //3

        for (int i = 0; i < T; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            pq1 = new PriorityQueue<>(Collections.reverseOrder());
            pq2 = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); //9

            st = new StringTokenizer(br.readLine()); //1 2 3 4 5 6 7 8 9
            int middle = Integer.parseInt(st.nextToken());
            list.add(middle);

            while (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int b = Integer.parseInt(st.nextToken());

                middle = put(a, b, middle);
                list.add(middle);
            }

            System.out.println(list.size());
            for (int j = 0; j < list.size(); j++) {
                if (j > 0 && j % 10 == 0)
                    System.out.println();
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static int put(int a, int b, int middle) {
        if (a >= middle && b >= middle) {
            pq2.add(a);
            pq2.add(b);
            pq1.add(middle);
            middle = pq2.poll();
        } else if (a >= middle && b <= middle) {
            pq1.add(b);
            pq2.add(a);
        } else if (a <= middle && b >= middle) {
            pq1.add(a);
            pq2.add(b);
        } else {
            pq1.add(a);
            pq1.add(b);
            pq2.add(middle);
            middle = pq1.poll();
        }

        return middle;
    }

}