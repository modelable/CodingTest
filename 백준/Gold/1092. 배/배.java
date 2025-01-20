import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> crane = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(box, Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) {
            System.out.println("-1");
            return;
        }

        int answer = 0;

        while (true) {
            for (int i = 0; i < crane.size(); i++) {
                for (int j = 0; j < box.size(); j++) {
                    if (box.isEmpty())
                        break;

                    if (box.get(j) <= crane.get(i)) {
                        box.remove(j);
                        break;
                    }
                }
                if (box.isEmpty()) {
                    System.out.println(++answer);
                    return;
                }
            }
            answer++;
        }
    }
}