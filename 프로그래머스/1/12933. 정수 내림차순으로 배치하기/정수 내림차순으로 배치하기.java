import java.util.*;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        Integer[] array = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(i) - '0';
        }

        Arrays.sort(array, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (Integer i : array) {
            sb.append(i);
        }

        long answer = Long.parseLong(sb.toString());

        return answer;
    }
}