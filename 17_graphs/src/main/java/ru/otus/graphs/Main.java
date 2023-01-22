package ru.otus.graphs;

import ru.otus.graphs.parse.FileParser;
import ru.otus.graphs.parse.GraphCreator;
import ru.otus.graphs.parse.GraphInfo;
import ru.otus.graphs.represenation.AdjacencyMatrixGraph;
import ru.otus.graphs.represenation.AdjacencySetGraph;
import ru.otus.graphs.represenation.Graph;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileParser fileParser = new FileParser();
        List<String> listOfFiles = new ArrayList<>(List.of(
                "graph1.txt",
                "graph2.txt",
                "graph3.txt",
                "graph4.txt",
                "graph5.txt"));

        List<Class<? extends Graph>> graphRepresentations = new ArrayList<>(List.of(AdjacencySetGraph.class,
                AdjacencyMatrixGraph.class));

        List<GraphInfo> graphInfos = listOfFiles.stream().map(fileParser::parseResource).collect(Collectors.toList());

        for (GraphInfo graphInfo : graphInfos) {
            System.out.println(graphInfo.getResource());
            for (Class<? extends Graph> clazz : graphRepresentations) {
                GraphCreator creator = new GraphCreator(graphInfo);
                Graph graph = creator.createGraph(clazz);
                System.out.println(graph);
                System.out.println("\n");
            }
        }
    }
}
