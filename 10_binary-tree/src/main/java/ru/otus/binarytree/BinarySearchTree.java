package ru.otus.binarytree;

public class BinarySearchTree<T extends Comparable<? super T>> implements BinaryTree<T> {
    private BinaryNode<T> root;

    @Override
    public void clear() {
        root = null;
    }

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(T item) {
        root = insert(root, item);
    }

    @Override
    public void remove(T item) {
        root = remove(root, item);
    }

    @Override
    public boolean contains(T item) {
        return contains(root, item);
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            return printTree(root);
        }
    }

    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T element) {
            this(element, null, null);
        }

        public BinaryNode(T theElement, BinaryNode<T> lNode, BinaryNode<T> rNode) {
            element = theElement;
            left = lNode;
            right = rNode;
        }
    }

    private BinaryNode<T> insert(BinaryNode<T> node, T element) {
        if (node == null) {
            return new BinaryNode<T>(element, null, null);
        }
        if (element.compareTo(node.element) > 0) {
            node.left = insert(node.left, element);
        } else {
            node.right = insert(node.right, element);
        }
        return node;
    }

    private BinaryNode<T> remove(BinaryNode<T> node, T element) {
        if (node == null) {
            return null;
        }
        int compareResult = element.compareTo(node.element);
        if (compareResult > 0) {
            node.left = remove(node.left, element);
        } else if (compareResult < 0) {
            node.right = remove(node.right, element);
        } else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.right, node.element);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMin(node.right);
    }

    private boolean contains(BinaryNode<T> node, T element) {
        if (node == null) {
            return false;
        }
        int compareResult = element.compareTo(node.element);
        if (compareResult > 0) {
            return contains(node.left, element);
        } else if (compareResult < 0) {
            return contains(node.right, element);
        } else {
            return true;
        }
    }

    private int getHeight(BinaryNode<T> node) {
        if (node == null) return 0;
        int leftHeight = 0;
        int rightHeight = 0;

        if (node.left != null) leftHeight = getHeight(node.left);
        if (node.right != null) rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private String printTree(BinaryNode<T> node) {
        if (node == null)
            return "";

        StringBuilder str = new StringBuilder();
        // push the root data as character
        str.append(node.element);

        // if leaf node, then return
        if (node.left == null && node.right == null)
            return str.toString();

        // for left subtree
        str.append("(");
        str.append(printTree(node.left));
        str.append(")");

        // only if right child is present to
        // avoid extra parenthesis
        str.append("(");
        if (node.right != null)
        {
            str.append(printTree(node.right));
        }
        str.append(")");
        return str.toString();
    }
}
