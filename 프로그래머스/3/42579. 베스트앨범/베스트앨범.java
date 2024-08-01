import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        HashMap<String, Integer> sum = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String[]> sortedGenres = new ArrayList<>();
        for (String genre : sum.keySet()) {
            sortedGenres.add(new String[]{genre, String.valueOf(sum.get(genre))});
        }

        sortedGenres.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]); // 내림차순
            };
        });

        HashMap<String, ArrayList<Integer[]>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
           ArrayList<Integer[]> list = map.getOrDefault(genres[i], new ArrayList<>());
           Integer[] arr = {plays[i], i};
           list.add(arr);
           map.put(genres[i], list);
        }

        // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        ArrayList<Integer> answer = new ArrayList<>();
        for (String[] str : sortedGenres) {
            ArrayList<Integer[]> list = map.get(str[0]);
            list.sort(new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
                    if (o1[0].equals(o2[0])) {
                        return o1[1] - o2[1];
                    } else {
                        return o2[0] - o1[0];
                    }
                };
            });
            answer.add(list.get(0)[1]);
            if (list.size() > 1) {
                answer.add(list.get(1)[1]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}