import java.util.Arrays;

class Solution {
    private static int answer;

    public static void main(String[] args) {
        int ans = solution(200, new int[]{0, 5, 100}, new int[]{5, 1});
        System.out.println(ans);
    }

    public static int solution(int n, int[] weak, int[] dist) {
        int numOfWeak = weak.length, numOfFriends = dist.length;

        int[] diff = new int[numOfWeak]; //간격(diff)
        answer = n;
        Arrays.sort(dist);

        for (int i = 0; i < numOfWeak - 1; i++) {
            diff[i] = weak[i + 1] - weak[i];
        }
        diff[numOfWeak - 1] = n + weak[0] - weak[numOfWeak - 1];

        checkWall(diff, dist, numOfFriends - 1, 0, new boolean[numOfWeak]);

        if (answer == n) { //답을 찾지 못한 경우
            if (numOfWeak == numOfFriends)
                return numOfFriends;
            else return -1;
        }
        else return answer;
    }

    public static void checkWall(int[] diff, int[] dist, int dIndex, int current, boolean[] visited) {

        if (current >= answer) return; //backtracking

        int count = 0;
        boolean check = false;
        //모든 취약점을 방문한 경우
        for (int i = 0; i < visited.length; i++) {
            if (i < visited.length - 1 && visited[i] != visited[i + 1])
                count++; //띄엄띄엄 발생(탐색 필요성 X)
            if (!visited[i])
                check = true; //해결되지 않음
            if (!check && i == visited.length - 1) {
                answer = current;
                return;
            }
        }

        if (count > dIndex + 2)
            return; //가능성이 없는 탐색
        if (current + 1 == answer) return;
        if (dIndex < 0) return;

//        System.out.print("dIndex: " + dIndex + ", current: " + current);
//        System.out.print(", [");
//        for (int i = 0; i < visited.length; i++) {
//            System.out.print(visited[i] + ", ");
//        }
//        System.out.println("]");

        //완전 탐색
        for (int i = 0; i < diff.length; i++) {
            if (visited[i] && visited[(i + 1) % diff.length])
                continue;

            int distance = dist[dIndex];

            boolean[] visited2 = visited.clone();

            int j = i;
            if (distance - diff[j] >= 0) {
                while (distance - diff[j] >= 0) {
                    if (visited2[j] && visited2[(j + 1) % diff.length]) break;
                    else {
                        distance -= diff[j];
                        visited2[j] = true;
                        j = (j + 1) % diff.length;
                        visited2[j] = true;
                    }
                }
            } else if (!visited2[i]) { //단일 취약점
                visited2[i] = true;
            }

            checkWall(diff, dist, dIndex - 1, current + 1, visited2);
        }
    }
}