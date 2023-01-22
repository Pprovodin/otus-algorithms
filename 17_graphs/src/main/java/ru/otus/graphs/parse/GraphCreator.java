package ru.otus.graphs.parse;

import ru.otus.graphs.represenation.Graph;
import ru.otus.graphs.represenation.Vertex;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GraphCreator {
    GraphInfo graphInfo;

    public GraphCreator(GraphInfo graphInfo) {
        this.graphInfo = graphInfo;
    }

    public <T extends Graph> Graph createGraph(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Graph graph = clazz.getDeclaredConstructor(int.class).newInstance(graphInfo.getNumberOfVertexes());
        if (validateGraphInfo()) {
            graphInfo.getVertexes()
                    .forEach(s ->
                            graph.addEdge(new Vertex(s.get(0).toString()), new Vertex(s.get(1).toString()), s.get(2)));
        } else {
            throw new RuntimeException("Something went wrong.");
        }
        return graph;
    }

    private boolean validateGraphInfo() {
        if (graphInfo.getNumberOfEdges() == 0 || graphInfo.getNumberOfVertexes() == 0)
            return false;
        for (List<Integer> s : graphInfo.getVertexes()) {
            if (s.size() != 3)
                return false;
        }
        return true;
    }


}
