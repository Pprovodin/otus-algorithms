package ru.otus.barn.impl;

import ru.otus.barn.BarnSolution;

public class BarnBestSolution implements BarnSolution {
    int size;
    boolean[][] map;
    int[] line;
    int[] R;
    int[] L;

    public BarnBestSolution(boolean[][] map) {
        this.size = map.length;
        this.map = map;
        this.line = new int[size];
        this.R = new int[size];
        this.L = new int[size];
    }

    public int solve() {
        int maxSquare = 0;
        for (int y = 0; y < size; y++) {
            calculateLineHeight(y);
            calculateRightsRanges();
            calculateLeftsRanges();
            for (int x = 0; x < size; x++) {
                int height = line[x];
                int width = R[x] - L[x] + 1;
                int square = height * width;
                if (maxSquare < square)
                    maxSquare = square;
            }
        }
        return maxSquare;
    }

    private void calculateRightsRanges() {
        MyStack stack = new MyStack(size);
        for (int x = 0; x < size; x++) {
            while (!stack.empty()) {
                if (line[stack.peek()] > line[x]) {
                    R[stack.pop()] = x - 1;
                } else {
                    break;
                }
            }
            stack.push(x);
        }
        while (!stack.empty())
            R[stack.pop()] = size - 1;
    }

    private void calculateLeftsRanges() {
        MyStack stack = new MyStack(size);
        for (int x = size - 1; x >= 0; x--) {
            while (!stack.empty()) {
                if (line[stack.peek()] > line[x]) {
                    L[stack.pop()] = x + 1;
                } else {
                    break;
                }
            }
            stack.push(x);
        }
        while (!stack.empty())
            R[stack.pop()] = 0;
    }

    private void calculateLineHeight(int y) {
        for (int x = 0; x < size; x++) {
            if(map[x][y])
                line[x] = 0;
            else
                line[x]++;
        }
    }

//    public void traversePreOrderWithoutRecursion() {
//        Stack<Node> stack = new Stack<Node>();
//        Node current = root;
//        stack.push(root);
//        while(!stack.isEmpty()) {
//            current = stack.pop();
//            visit(current.value);
//
//            if(current.right != null) {
//                stack.push(current.right);
//            }
//            if(current.left != null) {
//                stack.push(current.left);
//            }
//        }
//    }
}
