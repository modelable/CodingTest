import java.util.*;

class Solution {

    public static int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> nodes = new ArrayList<>();

        //O(N)
        for (int i = 0; i < nodeinfo.length; i++) {
            Node node = new Node();
            node.number = i + 1;
            node.x = nodeinfo[i][0];
            node.y = nodeinfo[i][1];
            nodes.add(node);
        }

        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                //y좌표가 같은 경우 x좌표를 기준으로 오름차순 정렬
                if (o1.y == o2.y) return o1.x - o2.x;
                    //y좌표를 기준으로 내림차순 정렬
                else return o2.y - o1.y;
            }
        });
        Node root = nodes.remove(0);
        init(root, nodes);

        int[][] answer = new int[2][];
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        preorder(pre, root);
        postorder(post, root);

        answer[0] = pre.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = post.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void init(Node node, ArrayList<Node> list) {
        if (node == null || list.isEmpty()) return;
        
        //자식 노드 설정
        if (list.get(0).x < node.x) {
            node.left = list.remove(0); //왼쪽 자식인 경우
            if (!list.isEmpty() && list.get(0).y == node.left.y) { //오른쪽 자식도 존재하는 경우
                node.right = list.remove(0);
            }
        } else { //오른쪽 자식인 경우
            node.right = list.remove(0);
        }

        ArrayList<Node> leftChild = new ArrayList<>();
        ArrayList<Node> rightChild = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x < node.x) {
                leftChild.add(list.get(i));
            } else {
                rightChild.add(list.get(i));
            }
        }

        init(node.left, leftChild);
        init(node.right, rightChild);
    }

    public static void preorder(ArrayList<Integer> list, Node node) {
        list.add(node.number);
        if (node.left != null) preorder(list, node.left);
        if (node.right != null) preorder(list, node.right);
    }

    public static void postorder(ArrayList<Integer> list, Node node) {
        if (node.left != null) postorder(list, node.left);
        if (node.right != null) postorder(list, node.right);
        list.add(node.number);
    }
    static class Node {
        int number;
        int x;
        int y;
        Node left;
        Node right;
    }
}