import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Number {
        int value;
        int sign;

        Number (int value, int sign) {
            this.value = value;
            this.sign = sign;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Number> pq = new PriorityQueue<>(new Comparator<Number>(){
            public int compare(Number o1, Number o2) {
                if (o1.value == o2.value)
                    return o1.sign - o2.sign;
                return o1.value - o2.value;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x > 0) {
                pq.add(new Number(x, 1));
            } else if (x < 0) {
                pq.add(new Number(-1 * x, -1));
            } else {
                if (pq.isEmpty()) System.out.println(0);
                else {
                    Number num = pq.poll();
                    if (num.sign == -1) System.out.println(num.value * -1);
                    else System.out.println(num.value);
                }
            }
        }
    }
}