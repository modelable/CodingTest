public class Solution {

    private int max;
    private int[] apeach;
    private int[] lion;
    public static final int SCORE_NUM = 11;

    public int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;

        backtrack(n, 0, new int[11]);

        return (max == 0) ? new int[]{-1} : lion;
    }

    public int getScore(int[] array) {
        int score = 0;

        for (int i = 0; i < SCORE_NUM; i++) {
            if (apeach[i] > 0 || array[i] > 0) {
                if (apeach[i] < array[i]) score += 10 - i;
                else score -= 10 - i;    
            }
        }

        return score;
    }

    public void check(int[] array) {
        int score = getScore(array);

        if (max < score) {
            max = score;
            lion = array.clone();
        } else if (max > 0 && max == score) {
            for (int i = SCORE_NUM - 1; i >= 0; i--) {
                if (lion[i] != array[i]) {
                    if (lion[i] < array[i]) {
                        lion = array.clone();
                    }
                    break;
                }
            }
        }
    }

    public void backtrack(int n, int index, int[] array) {

        if (n == 0) {
            check(array);
            return;
        }

        for (int i = index; i < SCORE_NUM; i++) {
            int count = Math.min(n, apeach[i] + 1);
            array[i] = count;
            backtrack(n - count, i + 1, array);
            array[i] = 0;
        }
    }
}