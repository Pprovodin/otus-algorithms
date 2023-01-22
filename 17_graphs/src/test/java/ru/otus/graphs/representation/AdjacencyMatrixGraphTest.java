package ru.otus.graphs.representation;

import org.junit.Assert;
import org.junit.Test;
import ru.otus.graphs.represenation.*;

import java.util.Set;

public class AdjacencyMatrixGraphTest {

    @Test
    public void testSimpleGraph() {
        Graph graph = new AdjacencyMatrixGraph(5, false);

        graph.addEdge(new Vertex("1"), new Vertex("2"), 1);
        graph.addEdge(new Vertex("2"), new Vertex("3"), 1);
        graph.addEdge(new Vertex("2"), new Vertex("4"), 1);
        graph.addEdge(new Vertex("3"), new Vertex("4"), 1);
        graph.addEdge(new Vertex("5"), new Vertex("5"), 1);

        int[][] expectedArray = new int[][] {{0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        Graph expected = new AdjacencyMatrixGraph(expectedArray, 5, false);

        Assert.assertEquals(expected, graph);
    }

    @Test
    public void testWeightedGraph() {
        Graph graph = new AdjacencyMatrixGraph(7, false);

        graph.addEdge(new Vertex("1"), new Vertex("2"), 7);
        graph.addEdge(new Vertex("2"), new Vertex("1"), 7);
        graph.addEdge(new Vertex("2"), new Vertex("3"), 2);
        graph.addEdge(new Vertex("2"), new Vertex("4"), 10);
        graph.addEdge(new Vertex("2"), new Vertex("6"), 8);
        graph.addEdge(new Vertex("2"), new Vertex("7"), 9);
        graph.addEdge(new Vertex("3"), new Vertex("2"), 2);
        graph.addEdge(new Vertex("3"), new Vertex("7"), 1);
        graph.addEdge(new Vertex("4"), new Vertex("2"), 10);
        graph.addEdge(new Vertex("4"), new Vertex("5"), 5);
        graph.addEdge(new Vertex("4"), new Vertex("7"), 3);
        graph.addEdge(new Vertex("5"), new Vertex("4"), 5);
        graph.addEdge(new Vertex("5"), new Vertex("6"), 4);
        graph.addEdge(new Vertex("6"), new Vertex("2"), 8);
        graph.addEdge(new Vertex("6"), new Vertex("5"), 4);
        graph.addEdge(new Vertex("6"), new Vertex("7"), 6);
        graph.addEdge(new Vertex("7"), new Vertex("2"), 9);
        graph.addEdge(new Vertex("7"), new Vertex("3"), 1);
        graph.addEdge(new Vertex("7"), new Vertex("4"), 3);
        graph.addEdge(new Vertex("7"), new Vertex("6"), 6);

        Graph expectedGraph = new AdjacencyMatrixGraph(7, false);

        expectedGraph.addEdge(new Vertex("1"), new Vertex("2"), 7);
        expectedGraph.addEdge(new Vertex("2"), new Vertex("3"), 2);
        expectedGraph.addEdge(new Vertex("2"), new Vertex("4"), 10);
        expectedGraph.addEdge(new Vertex("2"), new Vertex("6"), 8);
        expectedGraph.addEdge(new Vertex("2"), new Vertex("7"), 9);
        expectedGraph.addEdge(new Vertex("3"), new Vertex("7"), 1);
        expectedGraph.addEdge(new Vertex("4"), new Vertex("5"), 5);
        expectedGraph.addEdge(new Vertex("4"), new Vertex("7"), 3);
        expectedGraph.addEdge(new Vertex("5"), new Vertex("6"), 4);
        expectedGraph.addEdge(new Vertex("6"), new Vertex("7"), 6);

        Assert.assertEquals(expectedGraph, graph);
        Assert.assertTrue(graph.isAdjacent(new Vertex("2"), new Vertex("3")));
        Assert.assertFalse(graph.isAdjacent(new Vertex("2"), new Vertex("5")));

        Set<Vertex> adjacentVertexes = Set.of(new Vertex("1"), new Vertex("3"), new Vertex("4"),
                new Vertex("6"), new Vertex("7"));

        Assert.assertEquals(adjacentVertexes, graph.getAdjacentVertexes(new Vertex("2")));
        Assert.assertEquals(5, graph.getVertexPower(new Vertex("2")));
    }

    @Test
    public void testDirectedGraph() {
        Graph graph = new AdjacencyMatrixGraph(7);

        graph.addEdge(new Vertex("1"), new Vertex("2"), 7);
        graph.addEdge(new Vertex("2"), new Vertex("3"), 2);
        graph.addEdge(new Vertex("2"), new Vertex("4"), 10);
        graph.addEdge(new Vertex("2"), new Vertex("7"), 9);
        graph.addEdge(new Vertex("3"), new Vertex("7"), 1);
        graph.addEdge(new Vertex("4"), new Vertex("5"), 5);
        graph.addEdge(new Vertex("4"), new Vertex("7"), 3);
        graph.addEdge(new Vertex("5"), new Vertex("6"), 4);
        graph.addEdge(new Vertex("6"), new Vertex("2"), 8);
        graph.addEdge(new Vertex("6"), new Vertex("7"), 6);

        Assert.assertTrue(graph.isAdjacent(new Vertex("2"), new Vertex("3")));
        Assert.assertFalse(graph.isAdjacent(new Vertex("3"), new Vertex("2")));

        Set<Vertex> adjacentVertexes = Set.of(new Vertex("3"), new Vertex("4"),
                new Vertex("7"));

        Assert.assertEquals(adjacentVertexes, graph.getAdjacentVertexes(new Vertex("2")));
        Assert.assertEquals(3, graph.getVertexPower(new Vertex("2")));
    }
}
