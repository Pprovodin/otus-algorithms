package ru.otus.graphs.represenation;

import java.util.Set;

public interface Graph {

    void addVertex(Vertex vertex);
    void removeVertex(Vertex vertex);
    void addEdge(Vertex vertexFrom, Vertex vertexTo, int weight);
    void removeEdge(Vertex vertexFrom, Vertex vertexTo);
    boolean isAdjacent(Vertex a, Vertex b);
    Set<Vertex> getAdjacentVertexes(Vertex vertex);
    int getVertexPower(Vertex vertex);
    int getWeightBetweenVertexes(Vertex vertexFrom, Vertex vertexTo);
    void clear();
}
