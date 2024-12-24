import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static String solution(int[] number) {

        Integer[] numbers = Arrays.stream(number).boxed().toArray(Integer[]::new);

        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1.toString() + o2.toString();
                String str2 = o2.toString() + o1.toString();
                int num1 = Integer.parseInt(str1);
                int num2 = Integer.parseInt(str2);

                return num2 - num1;
            }
        });

        if (numbers[0] == 0)
            return "0";

        StringBuilder sb = new StringBuilder();

        for (Integer num : numbers) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}