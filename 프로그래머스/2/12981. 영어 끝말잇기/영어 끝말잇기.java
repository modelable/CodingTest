import java.util.*;

class Solution {
    public static int[] solution(int n, String[] words) {
        int[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String last = list.get(i - 1);

            if (list.contains(words[i]) || last.charAt(last.length() - 1) != words[i].charAt(0)) {
                System.out.println(words[i] + i);
                return new int[]{i % n + 1, i/n+1};
            }

            list.add(words[i]);
        }

        return new int[]{0, 0};
    }
}