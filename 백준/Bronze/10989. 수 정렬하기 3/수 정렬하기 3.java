import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[10000];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            array[num - 1]++;
        }

        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < array[i]; j++) {
                bw.write((i + 1) + "\n");
            }
        }

        bw.flush();
    }
}