package ru.otus.graphs.representation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.graphs.represenation.AdjacencySetGraph;
import ru.otus.graphs.represenation.Edge;
import ru.otus.graphs.represenation.Graph;
import ru.otus.graphs.represenation.Vertex;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class AdjacencySetGraphTest {

    public Graph graph;

    @Before
    public void init() {
        graph = new AdjacencySetGraph(false);
    }

    @After
    public void destroy() {
        graph.clear();
    }

    @Test
    public void testSimpleGraph() {
        graph.addVertex(new Vertex("1"));
        graph.addVertex(new Vertex("2"));
        graph.addVertex(new Vertex("3"));
        graph.addVertex(new Vertex("4"));
        graph.addVertex(new Vertex("5"));

        graph.addEdge(new Vertex("1"), new Vertex("2"), 0);
        graph.addEdge(new Vertex("2"), new Vertex("3"), 0);
        graph.addEdge(new Vertex("2"), new Vertex("4"), 0);
        graph.addEdge(new Vertex("3"), new Vertex("4"), 0);
        graph.addEdge(new Vertex("5"), new Vertex("5"), 0);

        Map<Vertex, Set<Edge>> expectedMap = new HashMap<>() {{
           put(new Vertex("5"), Set.of(new Edge(new Vertex("5"), new Vertex("5"), 0)));
           put(new Vertex("1"), Set.of(new Edge(new Vertex("1"), new Vertex("2"), 0)));
           put(new Vertex("2"), Set.of(new Edge(new Vertex("2"), new Vertex("1"), 0),
                   new Edge(new Vertex("2"), new Vertex("3"), 0),
                   new Edge(new Vertex("2"), new Vertex("4"), 0)));
           put(new Vertex("3"), Set.of(new Edge(new Vertex("3"), new Vertex("2"), 0),
                   new Edge(new Vertex("3"), new Vertex("4"), 0)));
           put(new Vertex("4"), Set.of(new Edge(new Vertex("4"), new Vertex("2"), 0),
                   new Edge(new Vertex("4"), new Vertex("3"), 0)));
        }};

        Graph expected = new AdjacencySetGraph(expectedMap, false);
        Assert.assertEquals(expected, graph);
    }

    @Test
    public void testWeightedGraph() {
        graph.addVertex(new Vertex("1"));
        graph.addVertex(new Vertex("2"));
        graph.addVertex(new Vertex("3"));
        graph.addVertex(new Vertex("4"));
        graph.addVertex(new Vertex("5"));
        graph.addVertex(new Vertex("6"));
        graph.addVertex(new Vertex("7"));

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

        Graph expectedGraph = new AdjacencySetGraph(false);

        expectedGraph.addVertex(new Vertex("1"));
        expectedGraph.addVertex(new Vertex("2"));
        expectedGraph.addVertex(new Vertex("3"));
        expectedGraph.addVertex(new Vertex("4"));
        expectedGraph.addVertex(new Vertex("5"));
        expectedGraph.addVertex(new Vertex("6"));
        expectedGraph.addVertex(new Vertex("7"));

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
        AdjacencySetGraph graph = new AdjacencySetGraph(true);
        graph.addVertex(new Vertex("1"));
        graph.addVertex(new Vertex("2"));
        graph.addVertex(new Vertex("3"));
        graph.addVertex(new Vertex("4"));
        graph.addVertex(new Vertex("5"));
        graph.addVertex(new Vertex("6"));
        graph.addVertex(new Vertex("7"));

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
