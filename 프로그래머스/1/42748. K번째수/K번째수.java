import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0] - 1;
            int j = commands[n][1] - 1;
            int k = commands[n][2] - 1;

            int[] cut = new int[j - i + 1];

            for (int m = 0; m < cut.length; m++) {
                cut[m] = array[i + m];
            }

            Arrays.sort(cut);
            answer[n] = cut[k];
        }

        return answer;
    }
}