import java.util.*;

public class Main {

    public static void main(String[] args) {
        String exp = new Scanner(System.in).nextLine();
        int n = 0; //괄호 쌍의 개수

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') n++;
        }

        ArrayList<String> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < Math.pow(2, n) - 1; i++) {
            StringBuilder sb = new StringBuilder();
            String bin = Integer.toBinaryString(i);
            while (bin.length() < n) {
                bin = "0" + bin;
            }
            int count = 0;
            for (int j = 0; j < exp.length(); j++) {
                if (exp.charAt(j) == '(') {
                    stack.push(count);
                    if (bin.charAt(count++) == '1') {
                        sb.append('(');
                    }
                } else if (exp.charAt(j) == ')') {
                    if (!stack.isEmpty() && bin.charAt(stack.pop()) == '1') {
                        sb.append(')');
                    }
                } else {
                    sb.append(exp.charAt(j));
                }
            }
            list.add(sb.toString());
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i - 1).equals(list.get(i))) {
                continue;
            }
            System.out.println(list.get(i));
        }
    }
}