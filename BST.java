public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void insert(K key, V val) {
        root = insert(root, key, val);
    }

    private Node insert(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = insert(node.left, key, val);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, val);
        } else {
            node.val = val;
        }

        return node;
    }

    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node node, K key) {
        if (node == null) {
            return false;
        }
        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return contains(node.left, key);
        } else if (cmp > 0) {
            return contains(node.right, key);
        } else {
            return true;
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null; // Key not found
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            // Node with the key to be deleted found

            // Case 1: Node with no children or one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 2: Node with two children
            Node successor = findMin(node.right); // Find the in-order successor
            node.key = successor.key;
            node.val = successor.val;
            node.right = delete(node.right, successor.key); // Delete the in-order successor
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}