import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        // 초기화
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map2.put(discount[i], map2.getOrDefault(discount[i], 0) + 1);

            if (map.equals(map2))
                answer++;
        }

        // 비교
        for (int i = 0; i < discount.length - 10; i++) {

            map2.put(discount[i + 10], map2.getOrDefault(discount[i + 10], 0) + 1);
            if (map2.get(discount[i]) == 1) {
                map2.remove(discount[i]);
            } else {
                map2.put(discount[i], map2.get(discount[i]) - 1);
            }

            if (map.equals(map2))
                answer++;
        }

        return answer;
    }
}