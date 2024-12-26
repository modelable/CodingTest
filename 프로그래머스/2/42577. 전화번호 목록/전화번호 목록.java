import java.util.*;

class Solution {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, ((o1, o2) -> o2.length() - o1.length()));
        
        DecimalTree root = new DecimalTree();

        for (String s : phone_book) {
            DecimalTree current = root;
            boolean check = true;

            for (int i = 0; i < s.length(); i++) {
                if (current.children.containsKey(s.charAt(i))) {
                    //System.out.println("hi: " + s.charAt(i));
                    current = current.children.get(s.charAt(i));
                } else { //접두어가 없음
                    //System.out.println("bye: " + s.charAt(i));
                    check = false;
                    current.children.put(s.charAt(i), new DecimalTree());
                    current = current.children.get(s.charAt(i));
                }
            }

            if (check == true) {
                return false;
            }
        }

        return true;
    }

    public static class DecimalTree {
        HashMap<Character, DecimalTree> children;

        public DecimalTree() {
            children = new HashMap<>();
        }
    }
}