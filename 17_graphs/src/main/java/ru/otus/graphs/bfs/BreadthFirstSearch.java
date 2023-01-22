package ru.otus.graphs.bfs;

import ru.otus.graphs.represenation.Graph;
import ru.otus.graphs.represenation.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private Graph graph;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    public boolean hasPathBfs(Vertex source, Vertex dest) {
        HashMap<Vertex, Boolean> visited = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        visited.put(source, true);
        queue.offer(source);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            if (vertex.equals(dest)) return true;
            for (Vertex nextVertex : graph.getAdjacentVertexes(vertex)) {
                if (visited.get(nextVertex) == null && !queue.contains(nextVertex)) {
                    visited.put(nextVertex, true);
                    queue.offer(nextVertex);
                }
            }
        }
        return false;
    }

}
