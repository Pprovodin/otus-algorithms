package ru.otus.graphs.represenation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
public class AdjacencyMatrixGraph implements Graph {

    private int[][] adjacencyMatrix;
    private final int size;
    @Setter private boolean directed;

    public AdjacencyMatrixGraph(int size) {
        this.size = size;
        this.adjacencyMatrix = new int[size][size];
        this.directed = true;
    }

    public AdjacencyMatrixGraph(int size, boolean directed) {
        this.size = size;
        this.adjacencyMatrix = new int[size][size];
        this.directed = directed;
    }

    public AdjacencyMatrixGraph(int[][] adjacencyMatrix, int size, boolean directed) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.size = size;
        this.directed = directed;
    }


    @Override
    public void addVertex(Vertex vertex) {
        return;
    }

    @Override
    public void removeVertex(Vertex vertex) {
        return;
    }

    @Override
    public void addEdge(Vertex vertexFrom, Vertex vertexTo, int weight) {
        if (weight <= 1)
                weight = 1;
        int source = Integer.parseInt(vertexFrom.getLabel()) - 1;
        int destination = Integer.parseInt(vertexTo.getLabel()) - 1;

        if (source < size && source >= 0 && destination < size && destination >= 0) {
            adjacencyMatrix[source][destination] = weight;
            if (!directed) {
                adjacencyMatrix[destination][source] = weight;
            }
        }
    }

    @Override
    public void removeEdge(Vertex vertexFrom, Vertex vertexTo) {
        int source = Integer.parseInt(vertexFrom.getLabel()) - 1;
        int destination = Integer.parseInt(vertexTo.getLabel()) - 1;
        if (source < size && source >= 0 && destination < size && destination >= 0) {
            adjacencyMatrix[source][destination] = 0;
            if (!directed) {
                adjacencyMatrix[destination][source] = 0;
            }
        }
    }

    @Override
    public boolean isAdjacent(Vertex a, Vertex b) {
        int source = Integer.parseInt(a.getLabel()) - 1;
        int destination = Integer.parseInt(b.getLabel()) - 1;
        return adjacencyMatrix[source][destination] != 0;
    }

    @Override
    public Set<Vertex> getAdjacentVertexes(Vertex vertex) {
        Set<Vertex> adjacentVertexes = new HashSet<>();
        int source = Integer.parseInt(vertex.getLabel()) - 1;

        for (int i = 0; i < adjacencyMatrix[source].length; i++) {
            if (adjacencyMatrix[source][i] != 0) {
                adjacentVertexes.add(new Vertex(String.valueOf(i + 1)));
            }
        }
        return adjacentVertexes;
    }

    @Override
    public int getVertexPower(Vertex vertex) {
        int source = Integer.parseInt(vertex.getLabel()) - 1;
        return (int) Arrays.stream(adjacencyMatrix[source]).filter(v -> v != 0).count();
    }

    @Override
    public int getWeightBetweenVertexes(Vertex vertexFrom, Vertex vertexTo) {
        int source = Integer.parseInt(vertexFrom.getLabel()) - 1;
        int destination = Integer.parseInt(vertexTo.getLabel()) - 1;
        if (source < size && source >= 0 && destination < size && destination >= 0) {
            return adjacencyMatrix[source][destination];
        }
        return 0;
    }

    @Override
    public void clear() {
        return;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(adjacencyMatrix);
    }
}
