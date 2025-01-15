import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                    pq1.add(n);
                    pq2.add(n);
                } else {
                    if (map.isEmpty())
                        continue;

                    if (n == 1) { //최댓값 삭제
                        remove(pq2, map);
                    } else { //최솟값 삭제
                        remove(pq1, map);
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                int num = remove(pq2, map);
                System.out.print(num);
                if (!map.isEmpty())
                    System.out.println(" " + remove(pq1, map));
                else System.out.println(" " + num);
            }
        }
    }

    public static int remove(PriorityQueue<Integer> queue, HashMap<Integer, Integer> map) {
        int num = -1;

        while (!queue.isEmpty()) {
            num = queue.poll();
            int count = map.getOrDefault(num, 0);

            if (count == 1) {
                map.remove(num);
                break;
            } else if (count > 1) {
                map.put(num, count - 1);
                break;
            }
        }
        return num;
    }


}