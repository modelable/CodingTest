import java.util.*;
class Solution {
    private static int result;
    public static int solution(int[] info, int[][] edges) {
        int answer = 0;
        Node[] nodes = new Node[info.length];

        for (int i = 0; i < info.length; i++) {
            Node node = new Node();
            node.animal = info[i];
            node.index = i;
            nodes[i] = node;
        }

        for (int i = 0; i < edges.length; i++) {
            if (nodes[edges[i][0]].leftChild == null) {
                nodes[edges[i][0]].leftChild = nodes[edges[i][1]];
            } else {
                nodes[edges[i][0]].rightChild = nodes[edges[i][1]];
            }
        }

        ArrayList<Node> list = new ArrayList<>();
        list.add(nodes[0]);
        simulate(0, 0, list, nodes[0]);
        System.out.println("result: " + result);
        return result;
    }

    public static void simulate(int sheep, int wolf, ArrayList<Node> list, Node node) {
        if (list.isEmpty()) return;
//        //==debug==//
//        System.out.print("now: " + node.index + " ");
//        for (Node x : list) {
//            System.out.print(x.index);
//        }
//        System.out.println();

        list.remove(node);
        if (node.leftChild != null) list.add(node.leftChild);
        if (node.rightChild != null) list.add(node.rightChild);

        if (node.animal == 0) sheep++;
        else if (node.animal == 1) wolf++;

        if (sheep <= wolf) return;
        if (result < sheep) {
            result = sheep;
            System.out.print("!!now: " + node.index + " ");
            for (Node x : list) {
                System.out.print(x.index);
            }
            System.out.println("sheep:" + sheep);

        }

        for (Node n : list) {
            simulate(sheep, wolf, new ArrayList<>(list), n);
        }
    }

    static class Node {
        int animal; //0: 양, 1: 늑대
        int index;
        Node leftChild;
        Node rightChild;
    }
}