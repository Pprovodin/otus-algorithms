package ru.otus.binarytree;

import lombok.ToString;

import java.util.Random;

public class DescartesTree {
    private final Random random = new Random(123456789);
    private Node root;

    public DescartesTree() {
        root = null;
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int item) {
        root = insert(root, item);
    }

    protected Node insert(Node node, int element) {
        Node newNode = new Node(element);
        newNode.priority = random.nextInt();
        final SplitResult splitResult = split(node, element);
        return merge(merge(splitResult.leftNode, newNode), splitResult.rightNode);
    }

    public void remove(int item) {
        root = remove(root, item);
    }

    protected Node remove(Node node, int element) {
        final SplitResult leftSplit = split(node, element - 1);
        final SplitResult rightSplit = split(leftSplit.rightNode, element);
        return merge(leftSplit.leftNode, rightSplit.rightNode);
    }

    public boolean contains(int item) {
        return contains(root, item);
    }

    private boolean contains(Node node, int element) {
        if (node == null) {
            return false;
        }
        if (element > node.element) {
            return contains(node.left, element);
        } else if (element < node.element) {
            return contains(node.right, element);
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            return printTree(root);
        }
    }

    private String printTree(Node node) {
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

    private Node merge(Node leftNode, Node rightNode) {
        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }
        if (leftNode.priority > rightNode.priority) {
            leftNode.right = merge(leftNode.right, rightNode);
            return leftNode;
        } else {
            rightNode.left = merge(leftNode, rightNode.left);
            return rightNode;
        }
    }

    private SplitResult split(Node node, int element) {
        final SplitResult result = new SplitResult();

        if (node == null) {
            return result;
        }

        if (node.element > element) {
            result.leftNode = node;
            final SplitResult rightSplit = split(node.right, element);
            result.leftNode.right = rightSplit.leftNode;
            result.rightNode = rightSplit.rightNode;
        } else {
            result.rightNode = node;
            final SplitResult leftSplit = split(node.left, element);
            result.rightNode.left = leftSplit.rightNode;
            result.leftNode = leftSplit.leftNode;
        }

        return result;
    }

    @ToString
    private static class SplitResult {
        private Node leftNode;
        private Node rightNode;
    }

    @ToString
    private static class Node {
        Node left;
        Node right;
        int element;
        int height;
        int priority;

        public Node(int element) {
            this.element = element;
            height = 0;
        }
    }
}
