import java.util.*;

public class Solution {

    public static class Tangerine {
        public int tangerine;
        public int count;

        Tangerine(int tangerine, int count) {
            this.tangerine = tangerine;
            this.count = count;
        }
    }

    public static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>(); //(귤, 개수)
        int answer = 0;
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        Tangerine[] array = new Tangerine[map.size()];
        int i = 0;
        for (Integer key : map.keySet()) {
            array[i++] = new Tangerine(key, map.get(key));
        }
        Arrays.sort(array, (o1, o2) -> o2.count - o1.count);

        for (i = 0; i < array.length; i++) {
            //System.out.println("k = " + k + ", tangerine = " + array[i].tangerine);
            if (k > 0) {
                k -= array[i].count;
                answer++;
            } else
                break;
        }
        return answer;
    }
}