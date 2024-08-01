import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> map = new HashMap<>(); // 이 유저를 신고한 유저
        HashMap<String, Integer> index = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            index.put(id_list[i], i);
        }

        for (String str : report) {
            String[] split = str.split(" ");
            String userId = split[0];
            String reportId = split[1];

            HashSet<String> set = map.get(reportId);
            set.add(userId);

            map.put(reportId, set);
        }

        for (String reportId : map.keySet()) {
            if (map.get(reportId).size() >= k) {
                for (String userId : map.get(reportId)) {
                    answer[index.get(userId)]++;
                }
            }
        }

        return answer;
    }
}