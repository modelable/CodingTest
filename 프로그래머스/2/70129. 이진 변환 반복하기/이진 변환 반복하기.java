class Solution {
    private static int zero; //제거된 모든 0의 개수
    
    public static int[] solution(String s) {
        zero = 0;
        int count = 0;

        while (!s.equals("1")) {
            count++;
            s = convert(s);
        }

        return new int[]{count, zero};
    }

    public static String convert(String s) {
        int one = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                one++;
            }
        }

        zero += s.length() - one;

        StringBuilder sb = new StringBuilder();

        while (one > 0) {
            sb.append(one % 2);
            one /= 2;
        }

        return sb.toString();
    }
}