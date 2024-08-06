import java.util.*;

class Solution {
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> map = new HashMap<>();
        Node[] nodes = new Node[enroll.length];

        // 트리 초기화(O(N))
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
            Node node = new Node();
            node.name = enroll[i];
            if (!referral[i].equals("-"))
                node.parent = nodes[map.get(referral[i])];
            nodes[i] = node;
        }

        // 이익금 계산(O(N*log(M)))
        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int profit = amount[i] * 100;
            answer[map.get(sellerName)] += profit - (int) (profit * 0.1);

            while (nodes[map.get(sellerName)].parent != null && profit > 0) {
                sellerName = nodes[map.get(sellerName)].parent.name;
                profit = (int) (profit * 0.1);
                answer[map.get(sellerName)] += profit - (int) (profit * 0.1);
            }
        }

        return answer;
    }

    static class Node {
        String name = null;
        Node parent = null;
    }
}