package ru.otus.graphs.dfs;

import ru.otus.graphs.represenation.Graph;
import ru.otus.graphs.represenation.Vertex;

import java.util.HashMap;
import java.util.Stack;

public class DepthFirstSearch {
    private Graph graph;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    public boolean hasPathDfs(Vertex source, Vertex dest) {
        HashMap<Vertex, Boolean> visited = new HashMap<>();
        Stack<Vertex> stack = new Stack<>();
        visited.put(source, true);
        stack.push(source);
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if (vertex.equals(dest)) return true;
            for (Vertex nextVertex : graph.getAdjacentVertexes(vertex)) {
                if (visited.get(nextVertex) == null && !stack.contains(nextVertex)) {
                    visited.put(nextVertex, true);
                    stack.push(nextVertex);
                }
            }
        }
        return false;
    }
}
