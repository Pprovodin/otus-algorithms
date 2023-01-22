package ru.otus.graphs.parse;

import java.util.*;
import java.util.stream.Collectors;

public class FileParser {

    public GraphInfo parseResource(String fileName) {
        List<List<Integer>> vertexesInfo = new ArrayList<>();
        int numberOfVertexes;
        int numberOfEdges;
        Scanner scanner = new Scanner(Objects.requireNonNull(getClass().getClassLoader()
                .getResourceAsStream(fileName)));
        if (scanner.hasNextLine()) {
            String firstLine = scanner.nextLine();
            numberOfVertexes = Integer.parseInt(firstLine.split(" ")[0]);
            numberOfEdges = Integer.parseInt(firstLine.split(" ")[1]);
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                List<Integer> vertexes = Arrays.stream(nextLine.split(" "))
                        .map(s -> (s.replace("(", "").replace(")", "")))
                        .map(Integer::parseInt).collect(Collectors.toList());
                if (vertexes.size() < 2 || vertexes.size() > 3) {
                    throw new RuntimeException("File " + fileName + " is broken");
                }
                if (vertexes.size() == 2) {
                    vertexes.add(0);
                }
                vertexesInfo.add(vertexes);
            }
        } else {
            throw new RuntimeException("File " + fileName + " is broken");
        }
        return new GraphInfo(fileName, numberOfVertexes, numberOfEdges, vertexesInfo);
    }
}
