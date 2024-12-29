class Solution {
    public int[] solution(int b, int y) {
        int x;
        for (x = 1; x < Math.abs(b + y); x++) {
            if (b + y == ((b + 4) / 2 - x) * x) {
                break;
            }
        }

        return new int[]{(b + y) / x, x};
    }
}