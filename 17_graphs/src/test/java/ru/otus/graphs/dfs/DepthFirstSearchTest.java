package ru.otus.graphs.dfs;

import org.junit.Assert;
import org.junit.Test;
import ru.otus.graphs.bfs.BreadthFirstSearch;
import ru.otus.graphs.represenation.AdjacencySetGraph;
import ru.otus.graphs.represenation.Graph;
import ru.otus.graphs.represenation.Vertex;

public class DepthFirstSearchTest {

    @Test
    public void test() {
        Graph graph = new AdjacencySetGraph(7);
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
        graph.addEdge(new Vertex("10"), new Vertex("11"), 6);
        graph.addEdge(new Vertex("11"), new Vertex("10"), 6);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);

        Assert.assertTrue(depthFirstSearch.hasPathDfs(new Vertex("1"), new Vertex("2")));
        Assert.assertTrue(depthFirstSearch.hasPathDfs(new Vertex("1"), new Vertex("5")));
        Assert.assertTrue(depthFirstSearch.hasPathDfs(new Vertex("1"), new Vertex("6")));
        Assert.assertTrue(depthFirstSearch.hasPathDfs(new Vertex("1"), new Vertex("7")));
        Assert.assertTrue(depthFirstSearch.hasPathDfs(new Vertex("2"), new Vertex("5")));
        Assert.assertTrue(depthFirstSearch.hasPathDfs(new Vertex("1"), new Vertex("4")));
        Assert.assertTrue(depthFirstSearch.hasPathDfs(new Vertex("5"), new Vertex("3")));
        Assert.assertFalse(depthFirstSearch.hasPathDfs(new Vertex("11"), new Vertex("1")));
        Assert.assertFalse(depthFirstSearch.hasPathDfs(new Vertex("11"), new Vertex("2")));
        Assert.assertFalse(depthFirstSearch.hasPathDfs(new Vertex("11"), new Vertex("3")));
        Assert.assertFalse(depthFirstSearch.hasPathDfs(new Vertex("11"), new Vertex("4")));
        Assert.assertFalse(depthFirstSearch.hasPathDfs(new Vertex("11"), new Vertex("5")));
        Assert.assertFalse(depthFirstSearch.hasPathDfs(new Vertex("11"), new Vertex("6")));
        Assert.assertFalse(depthFirstSearch.hasPathDfs(new Vertex("11"), new Vertex("7")));
    }
}
