import java.util.*;

class Solution {

    private static int result;

    public static int solution(int[] info, int[][] edges) {
        Node[] nodes = new Node[info.length];

        // 노드 초기화
        for (int i = 0; i < info.length; i++) {
            Node node = new Node();
            node.animal = info[i];
            nodes[i] = node;
        }

        // 트리 생성
        for (int i = 0; i < edges.length; i++) {
            if (nodes[edges[i][0]].leftChild == null) {
                nodes[edges[i][0]].leftChild = nodes[edges[i][1]];
            } else {
                nodes[edges[i][0]].rightChild = nodes[edges[i][1]];
            }
        }

        // 시뮬레이션
        ArrayList<Node> list = new ArrayList<>();
        list.add(nodes[0]);
        simulate(0, 0, list, nodes[0]);

        return result;
    }

    public static void simulate(int sheep, int wolf, ArrayList<Node> list, Node node) {
        if (list.isEmpty()) return;

        list.remove(node);
        if (node.leftChild != null) list.add(node.leftChild);
        if (node.rightChild != null) list.add(node.rightChild);

        if (node.animal == 0) sheep++;
        else if (node.animal == 1) wolf++;

        if (sheep <= wolf) return;

        // 최댓값 갱신
        if (result < sheep) result = sheep;

        for (Node n : list) {
            simulate(sheep, wolf, new ArrayList<>(list), n);
        }
    }

    static class Node {
        int animal; //0: 양, 1: 늑대
        Node leftChild;
        Node rightChild;
    }
}