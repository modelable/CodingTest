import java.util.*;

public class Solution {
    public static String solution(int n, int k, String[] cmd) {
        Stack<Node> stack = new Stack<>(); // 휴지통
        Node root = new Node(0);
        Node prev = root;
        Node pointer = null;

        for(int i = 1; i < n; i++) {
            Node node = new Node(i);

            node.prev = prev;
            node.prev.next = node;
            prev = node;

            if (i == k)
                pointer = node;
        }

        for (String s : cmd) {
            //System.out.println(s);
            switch (s.charAt(0)) {
                case 'U': // 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
                    for (int up = Integer.valueOf(s.substring(2)); up > 0; up--) {
                        pointer = pointer.prev;
                    }
                    break;
                case 'D': // 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
                    for (int down = Integer.valueOf(s.substring(2)); down > 0; down--) {
                        pointer = pointer.next;
                    }
                    break;
                case 'C': // 현재 선택된 행을 삭제한 후,
                    stack.push(pointer);

                    if (pointer.prev != null) {
                        pointer.prev.next = pointer.next;
                    }

                    if (pointer.next != null) {
                        pointer.next.prev = pointer.prev;
                        pointer = pointer.next;
                    } else {
                        pointer = pointer.prev;
                    }

                    break;
                case 'Z': // 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
                    if (!stack.isEmpty()) {
                        Node pop = stack.pop();

                        if (pop.prev != null) pop.prev.next = pop;
                        if (pop.next != null) pop.next.prev = pop;
                    }
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            answer.append('O');
        }

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            answer.setCharAt(pop.index, 'X'); // O(1)
        }
        
        return answer.toString();
    }

    static class Node {
        Node prev = null;
        Node next = null;
        int index;

        Node(int index){
            this.index = index;
        }
    }
}