package ru.otus.graphs.planningtree;

import ru.otus.graphs.bfs.BreadthFirstSearch;
import ru.otus.graphs.represenation.AdjacencySetGraph;
import ru.otus.graphs.represenation.Edge;
import ru.otus.graphs.represenation.Graph;
import ru.otus.graphs.represenation.Vertex;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Krushkal {
    AdjacencySetGraph graph;

    public Krushkal(AdjacencySetGraph graph) {
        this.graph = graph;
    }

    public Graph createPlanningTree() {
        Set<Vertex> vertexes = graph.getAllVertexes();
        Graph planningTree = new AdjacencySetGraph(false);

        List<Edge> edges = graph.getAllEdges();
        edges.sort(Comparator.comparing(Edge::getWeight));

        for (Edge edge : edges) {
            Vertex vertex1 = edge.getVertexFrom();
            Vertex vertex2 = edge.getVertexTo();

            if (planningTree.getVertexPower(vertex1) == 0 || planningTree.getVertexPower(vertex2) == 0) {
                planningTree.addEdge(vertex1, vertex2, edge.getWeight());
            } else {
                BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(planningTree);
                if (!breadthFirstSearch.hasPathBfs(vertex1, vertex2)) {
                    planningTree.addEdge(vertex1, vertex2, edge.getWeight());
                }
            }
        }
        return planningTree;

    }


}
