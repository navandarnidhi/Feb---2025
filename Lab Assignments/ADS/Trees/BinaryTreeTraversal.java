import java.util.*;

class Node1 {
    int data;
    Node left, right;

    public Node1(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeTraversal {
    Node root;

    // Build tree using level order input
    public Node buildTreeFromLevelOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root node value: ");
        int rootVal = sc.nextInt();
        if (rootVal == -1) return null;

        Node root = new Node(rootVal);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.print("Enter left child of " + current.data + " (-1 for null): ");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                current.left = new Node(leftVal);
                queue.add(current.left);
            }

            System.out.print("Enter right child of " + current.data + " (-1 for null): ");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                current.right = new Node(rightVal);
                queue.add(current.right);
            }
        }
        return root;
    }

    // Traversals and utilities
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    void levelOrder(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    int sumNodes(Node node) {
        if (node == null) return 0;
        return node.data + sumNodes(node.left) + sumNodes(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        // Take user input
        tree.root = tree.buildTreeFromLevelOrder();

        // Display outputs
        System.out.print("\nPreorder traversal: ");
        tree.preorder(tree.root);

        System.out.print("\nInorder traversal: ");
        tree.inorder(tree.root);

        System.out.print("\nPostorder traversal: ");
        tree.postorder(tree.root);

        System.out.print("\nLevel Order traversal: ");
        tree.levelOrder(tree.root);

        System.out.println("\n\nHeight of tree: " + tree.height(tree.root));
        System.out.println("Count of nodes: " + tree.countNodes(tree.root));
        System.out.println("Sum of all nodes: " + tree.sumNodes(tree.root));
    }
}
