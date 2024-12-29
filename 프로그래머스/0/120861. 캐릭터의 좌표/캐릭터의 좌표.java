class Solution {
    private static int N, M;
    
    public int[] solution(String[] keyinput, int[] board) {
        N = board[1]; //세로
        M = board[0]; //가로

        int x = 0, y = 0;
        for (String s : keyinput) {
            switch (s) {
                case "up":
                    if (available(x, y + 1)) y++;
                    break; 
                case "down":
                    if (available(x, y - 1))
                        y--;
                    break; 
                case "left":
                    if (available(x - 1, y)) x--;
                    break;
                case "right":
                    if (available(x + 1, y)) x++;
                    break;
            }
        }
        
        return new int[]{x, y};
    }

    public static boolean available(int x, int y) {
        if (M / -2 <= x && x <= M / 2 &&
        N / -2 <= y && y <= N / 2) {
            return true;
        }
        return false;
    }
}