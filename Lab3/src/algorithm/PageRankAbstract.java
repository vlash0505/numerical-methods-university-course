package algorithm;

import parsing.Serializer;

import java.io.File;

public class PageRankAbstract {

    protected final int[][] adjacencyMatrix;
    protected final double[] result;
    protected final int size;

    public PageRankAbstract(File config) {
        adjacencyMatrix = Serializer.parsePRConfig(config);
        size = adjacencyMatrix.length;
        result = new double[size];
    }

}
