import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int size = (int)Math.pow(2, n) - 1;
        int[][] arr = new int[size][2];
        ArrayList<Integer[]> list = new ArrayList<>();
        f(n, 1, 3, 2, list);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = list.get(i)[j];
            }
        }

        return arr;
    }
    
    public static void f(int k, int from, int to, int stay, ArrayList<Integer[]> list) {
        if (k <= 0) return;
        final Integer[] move = {from, to};

        f(k-1, from, stay, to, list);
        list.add(move);
        f(k-1, stay, to, from, list);
    }
}