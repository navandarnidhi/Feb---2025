class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

class BST {
    Node root;

    BST() {
        root = null;
    }

    Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    Node search(Node node, int data) {
        if (node == null || node.data == data) {
            return node;
        }
        if (data < node.data) {
            return search(node.left, data);
        }
        return search(node.right, data);
    }

    Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    Node deleteNode(Node node, int data) {
        if (node == null) {
            return node;
        }
        if (data < node.data) {
            node.left = deleteNode(node.left, data);
        } else if (data > node.data) {
            node.right = deleteNode(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node temp = findMin(node.right);
            node.data = temp.data;
            node.right = deleteNode(node.right, temp.data);
        }
        return node;
    }

    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 7);

        System.out.print("In-order traversal: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        tree.root = tree.deleteNode(tree.root, 5);
        System.out.print("In-order traversal after deletion: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();
    }
}