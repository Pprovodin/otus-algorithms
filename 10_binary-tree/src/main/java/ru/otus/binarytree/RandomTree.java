package ru.otus.binarytree;

import lombok.Setter;

import java.util.Random;

public class RandomTree<T extends Comparable<? super T>> implements BinaryTree<T> {
    private TreapNode<T> root;
    @Setter private static int seed;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(T item) {
        root = insert(root, item);
    }

    private TreapNode<T> insert(TreapNode<T> node, T item) {
        if (node == null) {
            return new TreapNode<>(item, null, null);
        }

        int compareResult = item.compareTo(node.element);

        if (compareResult > 0) {
            node.left = insert(node.left, item);
            if (node.left != null && node.left.priority > node.priority) {
                node = rotateRight(node);
            }
        } else {
            node.right = insert(node.right, item);
            if (node.right != null && node.right.priority > node.priority) {
                node = rotateLeft(node);
            }
        }

        return node;
    }

    @Override
    public void remove(T item) {
        root = remove(root, item);
    }

    private TreapNode<T> remove(TreapNode<T> node, T item) {
        if (node == null) {
            return null;
        }

        int compareResult = item.compareTo(node.element);

        if (compareResult > 0) {
            node.left = remove(node.left, item);
        } else if (compareResult < 0) {
            node.right = remove(node.right, item);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left != null && node.right != null) {
                if (node.left.priority < node.right.priority) {
                    node = rotateLeft(node);
                    node.left = remove(node.left, item);
                } else {
                    node = rotateRight(node);
                    node.right = remove(node.right, item);
                }
            } else {
                // choose a child node
                node = (node.left != null) ? node.left: node.right;
            }
        }

        return node;

    }

    private TreapNode<T> rotateRight(TreapNode<T> node) {
        TreapNode<T> L = node.left;
        TreapNode<T> Y = node.left.right;
        L.right = node;
        node.left = Y;

        return L;
    }

    private TreapNode<T> rotateLeft(TreapNode<T> node) {
        TreapNode<T> R = node.right;
        TreapNode<T> X = node.right.left;

        R.left = node;
        node.right = X;
        return R;
    }

    @Override
    public boolean contains(T item) {
        return contains(root, item);
    }

    private boolean contains(TreapNode<T> node, T element) {
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

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreapNode<T> node) {
        if (node == null) return 0;
        int leftHeight = 0;
        int rightHeight = 0;

        if (node.left != null) leftHeight = getHeight(node.left);
        if (node.right != null) rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            return printTree(root);
        }
    }

    private String printTree(TreapNode<T> node) {
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
        if (node.right != null) {
            str.append(printTree(node.right));
        }
        str.append(")");
        return str.toString();
    }

    private static class TreapNode<T> {
        T element;
        TreapNode<T> left;
        TreapNode<T> right;
        int height;
        int priority;

        public TreapNode(T element) {
            this(element, null, null);
        }

        public TreapNode(T element, TreapNode<T> left, TreapNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.priority = new Random(seed).nextInt(100);
            height = 0;
        }
    }
}
