package ru.otus.graphs.algorithms.shortestpath;

import org.junit.Test;
import ru.otus.graphs.algorithm.shortestpath.Dijkstra;
import ru.otus.graphs.algorithm.shortestpath.LinkedListGraph;
import ru.otus.graphs.algorithm.shortestpath.Node;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DijkstraTest {
    @Test
    public void whenSPPSolved_thenCorrect() {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        LinkedListGraph graph = new LinkedListGraph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

        List<Node> shortestPathForNodeB = List.of(nodeA);
        List<Node> shortestPathForNodeC = List.of(nodeA);
        List<Node> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List<Node> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
        List<Node> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

        for (Node node : graph.getNodes()) {
            switch (node.getLabel()) {
                case "B":
                    assertEquals(node.getShortestPath(), shortestPathForNodeB);
                    break;
                case "C":
                    assertEquals(node.getShortestPath(), shortestPathForNodeC);
                    break;
                case "D":
                    assertEquals(node.getShortestPath(), shortestPathForNodeD);
                    break;
                case "E":
                    assertEquals(node.getShortestPath(), shortestPathForNodeE);
                    break;
                case "F":
                    assertEquals(node.getShortestPath(), shortestPathForNodeF);
                    break;
            }
        }
    }
}
