package ru.otus.graphs.represenation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Vertex {
    private final String label;

    public Vertex(String label) {
        this.label = label;
    }

    public Vertex(String label, Integer weight) {
        this.label = label;
    }
}
