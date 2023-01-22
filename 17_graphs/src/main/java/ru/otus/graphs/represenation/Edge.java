package ru.otus.graphs.represenation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Edge {
    private final Vertex vertexFrom;
    private final Vertex vertexTo;
    private final int weight;

    public Edge(Vertex vertexFrom, Vertex vertexTo, int weight) {
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
        this.weight = weight;
    }
}
