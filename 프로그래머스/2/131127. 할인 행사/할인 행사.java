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
        }

        // 비교
        for (int i = 0; i < discount.length - 9; i++) {
            for (int j = 0; j < want.length; j++) {
                if (!(map.get(want[j]).equals(map2.getOrDefault(want[j], 0))))
                    break;
                
                if (j == want.length - 1) {
                    answer++;
                }
            }

            if (i < discount.length - 10) {
                map2.put(discount[i + 10], map2.getOrDefault(discount[i + 10], 0) + 1);
                map2.replace(discount[i], map2.get(discount[i]) - 1);
            }
        }

        return answer;
    }
}