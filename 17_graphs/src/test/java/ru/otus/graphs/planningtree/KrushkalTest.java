package ru.otus.graphs.planningtree;

import org.junit.Assert;
import org.junit.Test;
import ru.otus.graphs.represenation.AdjacencySetGraph;
import ru.otus.graphs.represenation.Edge;
import ru.otus.graphs.represenation.Vertex;

/**
 * Test for Krushkal Algorithm.
 * Initial data taken from tje lesson.
 *
 * But there are twice as many edges as in the lesson, since in my implementation undirected graph should keep
 * both edges twice.
 *
 */
public class KrushkalTest {

    @Test
    public void test() {
        AdjacencySetGraph graph = new AdjacencySetGraph(false);

        graph.addEdge(new Vertex("6"), new Vertex("7"), 1);
        graph.addEdge(new Vertex("11"), new Vertex("8"), 2);
        graph.addEdge(new Vertex("14"), new Vertex("15"), 3);
        graph.addEdge(new Vertex("9"), new Vertex("13"), 4);
        graph.addEdge(new Vertex("5"), new Vertex("10"), 5);
        graph.addEdge(new Vertex("5"), new Vertex("1"), 6);
        graph.addEdge(new Vertex("1"), new Vertex("2"), 7);
        graph.addEdge(new Vertex("7"), new Vertex("11"), 8);
        graph.addEdge(new Vertex("4"), new Vertex("12"), 9);
        graph.addEdge(new Vertex("12"), new Vertex("15"), 10);
        graph.addEdge(new Vertex("13"), new Vertex("14"), 11);
        graph.addEdge(new Vertex("10"), new Vertex("11"), 12);
        graph.addEdge(new Vertex("10"), new Vertex("7"), 13);
        graph.addEdge(new Vertex("6"), new Vertex("10"), 14);
        graph.addEdge(new Vertex("3"), new Vertex("7"), 15);
        graph.addEdge(new Vertex("2"), new Vertex("7"), 16);
        graph.addEdge(new Vertex("3"), new Vertex("4"), 17);
        graph.addEdge(new Vertex("3"), new Vertex("8"), 18);
        graph.addEdge(new Vertex("5"), new Vertex("9"), 19);
        graph.addEdge(new Vertex("13"), new Vertex("10"), 20);
        graph.addEdge(new Vertex("6"), new Vertex("2"), 21);
        graph.addEdge(new Vertex("6"), new Vertex("5"), 22);
        graph.addEdge(new Vertex("2"), new Vertex("3"), 23);
        graph.addEdge(new Vertex("14"), new Vertex("11"), 24);
        graph.addEdge(new Vertex("9"), new Vertex("10"), 25);
        graph.addEdge(new Vertex("4"), new Vertex("8"), 26);
        graph.addEdge(new Vertex("11"), new Vertex("12"), 27);
        graph.addEdge(new Vertex("10"), new Vertex("14"), 28);
        graph.addEdge(new Vertex("11"), new Vertex("15"), 29);
        graph.addEdge(new Vertex("7"), new Vertex("8"), 30);
        graph.addEdge(new Vertex("1"), new Vertex("6"), 31);
        graph.addEdge(new Vertex("8"), new Vertex("12"), 29);

        Krushkal krushkal = new Krushkal(graph);

        AdjacencySetGraph result = (AdjacencySetGraph) krushkal.createPlanningTree();

        Assert.assertEquals(220, result.getAllEdges().stream().map(Edge::getWeight).mapToInt(Integer::intValue).sum());
        Assert.assertEquals(28, result.getAllEdges().size());
    }
}
