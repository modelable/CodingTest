class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        if (a % 2 == 0) a--;

        for (int i = 2; i <= n; i *= 2) {
            answer++;
            int x = a / i;

            if (i * x < b && b <= i * x + i) {
                break;
            }
        }

        return answer;
    }
}