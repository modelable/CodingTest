import java.util.*;

class Solution {
    public static int[] solution(String s) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') {
                i++;
                ArrayList<Integer> temp = new ArrayList<>();

                while (s.charAt(i) != '}' && s.charAt(i) != ',') {
                    int start = i;
                    while (s.charAt(i) != ',' && s.charAt(i) != '}') {
                        i++;
                    }
                    //System.out.println(Integer.parseInt(s.substring(start, i)));
                    temp.add(Integer.parseInt(s.substring(start, i)));
                    i++;
                }
                list.add(temp);
            }
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.size() - o2.size();
        });

        for (ArrayList<Integer> temp : list) {
            for (Integer num : temp) {
                if (!set.contains(num)) {
                    answer.add(num);
                    set.add(num);
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}