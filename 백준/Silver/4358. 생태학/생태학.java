import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        int size = 0;

        while (true) {
            String tree = br.readLine();
            if (tree == null) break;
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            size++;
        }

        for (String key : map.keySet()) {
            list.add(key);
        }
        Collections.sort(list);

        for (String tree : list) {
            System.out.print(tree + " ");
            System.out.printf("%.4f\n", 100 * map.get(tree) / (double)size);
        }
    }
}