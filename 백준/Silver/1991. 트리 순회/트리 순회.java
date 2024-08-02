import java.util.*;

public class Main {

    private static HashMap<Character, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); //개행문자 제거

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Node parent, left, right;

            // 부모 노드
            if (map.get(line.charAt(0)) == null) {
                parent = new Node(line.charAt(0));
                map.put(parent.value, parent);
            } else {
                parent = map.get(line.charAt(0));
            }

            // 자식 노드(left)
            if (map.get(line.charAt(2)) == null && line.charAt(2) != '.') {
                left = new Node(line.charAt(2));
                map.put(left.value, left);
            } else {
                left = map.get(line.charAt(2));
            }

            // 자식 노드(right)
            if (map.get(line.charAt(4)) == null && line.charAt(4) != '.') {
                right = new Node(line.charAt(4));
                map.put(right.value, right);
            } else {
                right = map.get(line.charAt(4));
            }

            parent.left = left;
            parent.right = right;
        }

        preorder(map.get('A'));
        System.out.println();
        inorder(map.get('A'));
        System.out.println();
        postorder(map.get('A'));
    }

    //전위 순회
    public static void preorder(Node node) {
        System.out.print(node.value);
        if (node.left != null) preorder(map.get(node.left.value));
        if (node.right != null) preorder(node.right);
    }

    //중위 순회
    public static void inorder(Node node) {
        if (node.left != null) inorder(node.left);
        System.out.print(node.value);
        if (node.right != null) inorder(node.right);
    }

    //후위 순회
    public static void postorder(Node node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        System.out.print(node.value);
    }

    public static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }
}