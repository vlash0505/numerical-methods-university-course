package algorithm;

import parsing.Serializer;

import java.io.File;

public class PageRankIterative extends PageRankAbstract {
    private static final double DAMPING_FACTOR = 0.5;
    private static int CURRENT_STEP = 1;

    public PageRankIterative(File config) {
        super(config);

        buildResult();
    }

    public void buildResult() {
        double givenLinks;
        int externalNodeIndex;
        int internalNodeIndex;
        while (CURRENT_STEP <= 2) {
            double[] temp = new double[size];
            for (int k = 0; k < size; k++) {
                temp[k] = this.result[k];
                this.result[k] = 0;
            }

            for (internalNodeIndex = 0; internalNodeIndex < size; internalNodeIndex++) {
                for (externalNodeIndex = 0; externalNodeIndex < size; externalNodeIndex++) {
                    if (this.adjacencyMatrix[externalNodeIndex][internalNodeIndex] == 1) {
                        int k = 0;
                        givenLinks = 0;
                        while (k < size) {
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
        for (int i = 0; i < size; i++) {
            this.result[i] = (1 - DAMPING_FACTOR) + DAMPING_FACTOR * this.result[i];
        }
    }

    private void printResult() {
        System.out.println("\n Result : \n");
        for (int i = 0; i < size; i++) {
            System.out.printf("" + i + " : " + this.result[i] + "\n");
        }
    }
}