package ru.otus.graphs.parse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GraphInfo {
    private String resource;
    private int numberOfVertexes;
    private int numberOfEdges;
    private List<List<Integer>> vertexes;
}
