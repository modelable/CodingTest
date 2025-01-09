import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int s = 0, e = people.length - 1;
        Arrays.sort(people);
        
        while (s <= e) {
            if (people[s] + people[e] <= limit) {
                s++;
                e--;
            } else {
                e--;
            }
            answer++;
        }

        return answer;
    }
}