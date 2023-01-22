package ru.otus.graphs.represenation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
public class AdjacencySetGraph implements Graph {

    private final Map<Vertex, Set<Edge>> adjacentSet;
    @Setter private boolean directed;

    public AdjacencySetGraph() {
        this.adjacentSet = new HashMap<>();
        this.directed = true;
    }

    public AdjacencySetGraph(int size) {
        this.adjacentSet = new HashMap<>();
        this.directed = true;
    }

    public AdjacencySetGraph(Map<Vertex, Set<Edge>> adjacentSet) {
        this.adjacentSet = adjacentSet;
        this.directed = true;
    }

    public AdjacencySetGraph(boolean directed) {
        this.adjacentSet = new HashMap<>();
        this.directed = directed;
    }

    public AdjacencySetGraph(Map<Vertex, Set<Edge>> adjacentSet, boolean directed) {
        this.adjacentSet = adjacentSet;
        this.directed = directed;
    }

    public Set<Edge> getEdgesByVertex(Vertex vertex) {
        return adjacentSet.get(vertex);
    }

    @Override
    public void addVertex(Vertex vertex) {
        adjacentSet.putIfAbsent(vertex, new HashSet<>());
    }

    @Override
    public void removeVertex(Vertex vertex) {
        if (!directed) {
            Set<Edge> edges = adjacentSet.get(vertex);
            for (Edge edge: edges) {
                Edge edge1 = findEdgeByVertex(edge.getVertexTo(), vertex);
                adjacentSet.get(edge.getVertexTo()).remove(edge1);
            }
        } else {
            for (Vertex key: adjacentSet.keySet()) {
                Edge edge2 = findEdgeByVertex(key, vertex);
                if (edge2 != null)
                    adjacentSet.get(key).remove(edge2);
            }
        }
        adjacentSet.remove(vertex);
    }

    @Override
    public void addEdge(Vertex vertexFrom, Vertex vertexTo, int weight) {
        addVertex(vertexFrom);
        addVertex(vertexTo);
        Edge edge = new Edge(vertexFrom, vertexTo, weight);
        adjacentSet.get(vertexFrom).add(edge);
        if (vertexFrom.equals(vertexTo)) return;
        if (!directed) {
            edge = new Edge(vertexTo, vertexFrom, weight);
            adjacentSet.get(vertexTo).add(edge);
        }
    }

    @Override
    public void removeEdge(Vertex vertexFrom, Vertex vertexTo) {
        Set<Edge> edges1 = adjacentSet.get(vertexFrom);
        Set<Edge> edges2 = adjacentSet.get(vertexTo);
        if (edges1 == null || edges2 == null)
            return;
        Edge edge1 = findEdgeByVertex(vertexFrom, vertexTo);
        edges1.remove(edge1);
        if (!directed)  {
            Edge edge2 = findEdgeByVertex(vertexTo, vertexFrom);
            edges2.remove(edge2);
        }

    }

    @Override
    public boolean isAdjacent(Vertex a, Vertex b) {
        Edge edge1 = findEdgeByVertex(a, b);
        if (directed) {
            return edge1 != null;
        } else {
            Edge edge2 = findEdgeByVertex(b, a);
            return edge1 != null && edge2!= null;
        }
    }

    @Override
    public Set<Vertex> getAdjacentVertexes(Vertex vertex) {
        Set<Vertex> adjacentVertexes = new HashSet<>();
        Set<Edge> edges = adjacentSet.get(vertex);
        if (edges != null) {
            edges.forEach(e -> adjacentVertexes.add(e.getVertexTo()));
        }
        return adjacentVertexes;
    }

    @Override
    public int getVertexPower(Vertex vertex) {
        return getAdjacentVertexes(vertex).size();
    }

    @Override
    public int getWeightBetweenVertexes(Vertex vertexFrom, Vertex vertexTo) {
        return Objects.requireNonNull(findEdgeByVertex(vertexFrom, vertexTo)).getWeight();
    }

    @Override
    public void clear() {
        adjacentSet.clear();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Vertex key: adjacentSet.keySet()) {
            result.append(key).append(",").append(adjacentSet.get(key));
            result.append("\n");
        }
        result.append("directed = ").append(directed);
        return result.toString();
    }

    public Set<Vertex> getAllVertexes() {
        return adjacentSet.keySet();
    }

    public List<Edge> getAllEdges() {
        return adjacentSet.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    private Edge findEdgeByVertex(Vertex a, Vertex b) {
        Set<Edge> ne = adjacentSet.get(a);
        for (Edge edge: ne) {
            if (edge.getVertexTo().equals(b)) {
                return edge;
            }
        }
        return null;
    }
}
