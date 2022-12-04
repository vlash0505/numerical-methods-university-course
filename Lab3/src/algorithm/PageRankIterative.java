package algorithm;

import parsing.Serializer;

import java.io.File;

public class PageRankIterative {
    private static final double DAMPING_FACTOR = 0.5;

    private static int CURRENT_STEP = 1;

    private final int SIZE;
    public final int[][] adjacencyMatrix;
    public final double[] result;

    public PageRankIterative(File config) {
        adjacencyMatrix = Serializer.parsePRConfig(config);
        SIZE = adjacencyMatrix.length;
        result = new double[SIZE];

        buildResult();
    }

    public void buildResult() {
        double givenLinks;
        int externalNodeIndex;
        int internalNodeIndex;
        System.out.println("RESULTING SIZE: " + SIZE);
        while (CURRENT_STEP <= 2) {
            double[] temp = new double[SIZE];
            for (int k = 0; k < SIZE; k++) {
                temp[k] = this.result[k];
                this.result[k] = 0;
            }

            for (internalNodeIndex = 0; internalNodeIndex < SIZE; internalNodeIndex++) {
                for (externalNodeIndex = 0; externalNodeIndex < SIZE; externalNodeIndex++) {
                    if (this.adjacencyMatrix[externalNodeIndex][internalNodeIndex] == 1) {
                        int k = 0;
                        givenLinks = 0;
                        while (k < SIZE) {
                            if (this.adjacencyMatrix[externalNodeIndex][k] == 1) {
                                givenLinks++;
                            }
                            k++;
                        }
                        this.result[internalNodeIndex] += temp[externalNodeIndex] * (1 / givenLinks);
                    }
                }
            }
            CURRENT_STEP++;
        }
        addDampingFactor();
        printResult();
    }

    private void addDampingFactor() {
        for (int i = 0; i < SIZE; i++) {
            this.result[i] = (1 - DAMPING_FACTOR) + DAMPING_FACTOR * this.result[i];
        }
    }

    private void printResult() {
        System.out.println("\n Result : \n");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("" + i + " : " + this.result[i] + "\n");
        }
    }
}