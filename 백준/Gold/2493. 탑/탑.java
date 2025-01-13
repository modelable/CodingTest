import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] arr = new Node[N + 1];
        int[] answer = new int[N + 1];
        Stack<Node> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = new Node(Integer.parseInt(st.nextToken()), i);
        }

        stack.push(arr[N]);
        for (int i = N - 1; i > 0; i--) {
            while (!stack.isEmpty() && stack.peek().value <= arr[i].value) {
                Node pop = stack.pop();
                answer[pop.index] = i;
            }
            stack.push(arr[i]);
        }

        for (int i = 1; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }
}