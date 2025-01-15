import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();

            if (num == 0) {
                if (pq.isEmpty()) bw.write(0 + "\n");
                else bw.write(pq.poll() + "\n");
            } else {
                pq.add(num);
            }
        }

        bw.flush();
    }
}