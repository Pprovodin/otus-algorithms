package ru.otus.binarytree;

public class AvlTree<T extends Comparable<? super T>> implements BinaryTree<T> {
    private AvlNode<T> root;

    @Override
    public void clear() {
        root = null;
    }

    public AvlTree() {
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

    private static class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;// Высота узла

        public AvlNode(T element) {
            this(element, null, null);
        }

        public AvlNode(T theElment, AvlNode<T> lNode, AvlNode<T> rNode) {
            element = theElment;
            left = lNode;
            right = rNode;
            height = 0;
        }
    }

    private int height(AvlNode<T> node) {
        return node == null ? -1 : node.height;
    }

    private AvlNode<T> insert(AvlNode<T> node, T element) {
        if (node == null) {
            return new AvlNode<T>(element, null, null);
        }
        int compareResult = element.compareTo(node.element);

        if (compareResult > 0) {
            node.left = insert(node.left, element);
        } else if (compareResult < 0) {
            node.right = insert(node.right, element);
        }
        return balance(node);
    }

    private AvlNode<T> remove(AvlNode<T> node, T element) {
        if (node == null) {
            return node;
        }
        int compareResult = element.compareTo(node.element);
        if (compareResult < 0) {
            node.right = remove(node.right, element);
        } else if (compareResult > 0) {
            node.left = remove(node.left, element);
        } else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.right, node.element);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return balance(node);
    }

    private boolean contains(AvlNode<T> node, T element) {
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

    private AvlNode<T> findMin(AvlNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMin(node.right);
    }

    private int getHeight(AvlNode<T> node) {
        if (node == null) return 0;
        int leftHeight = 0;
        int rightHeight = 0;

        if (node.left != null) leftHeight = getHeight(node.left);
        if (node.right != null) rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private String printTree(AvlNode<T> node) {
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

    private AvlNode<T> balance(AvlNode<T> node) {
        if (node == null) {
            return node;
        }
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.right.right) > height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (height(node.left.left) > height(node.left.right))
                node = rotateRight(node);
            else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        updateHeight(node);
        return node;
    }

    AvlNode<T> rotateRight(AvlNode<T> y) {
        AvlNode<T> x = y.left;
        AvlNode<T> z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    AvlNode<T> rotateLeft(AvlNode<T> y) {
        AvlNode<T> x = y.right;
        AvlNode<T> z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    void updateHeight(AvlNode<T> n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    int getBalance(AvlNode<T> node) {
        return (node == null) ? 0 : height(node.right) - height(node.left);
    }

}
