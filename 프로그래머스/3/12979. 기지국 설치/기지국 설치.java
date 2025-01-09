import java.util.*;

public class Solution {
    
    //n: 아파트의 개수, stations: 기지국이 설치된 아파트의 번호, w: 전파의 도달 거리
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int num = 1;
        int range = 1 + 2 * w;

        for (int i = 0; i < stations.length; i++) {
            int start = stations[i] - w;
            int end = stations[i] + w;

            if (num < start) {
                answer += (start - num - 1) / range + 1;
            }
            num = end + 1;
        }

        if (num <= n) {
            answer += (n - num) / range + 1;
        }

        return answer;
    }
}