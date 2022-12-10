package algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PageRankAlgebraic extends PageRankAbstract {
    private static final double E = 0.0000001;
    private static final double J = 0.15;

    public PageRankAlgebraic(File config) {
        super(config);

        buildSolution();
    }

    private void buildSolution() {
        buildMarkovMatrix();
        buildMMatrix();
        rangeMatrix();
    }

    private double[][] buildMarkovMatrix() {
        double[][] result = new double[size][size];
        List<Integer> counters = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int counter = 0;
            for (int j = 0; j < size; j++) {
                if (adjacencyMatrix[j][i] == 1) {
                    counter++;
                }
            }
            counters.add(counter);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (adjacencyMatrix[j][i] == 1) {
                    result[j][i] = 1.0 / counters.get(i);
                }
            }
        }

        System.out.println("Resulting Markov matrix: ");
        Utils.printMatrix(result);

        return result;
    }

    private void buildMMatrix() {
        double[][] matrixB = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixB[i][j] = 1.0 / size;
            }
        }

        double[][] result = Utils.addMatrices(Utils.multiplyMatrixByScalar(matrixB, J), Utils.multiplyMatrixByScalar(buildMarkovMatrix(), 1 - J));
        System.out.println("Resulting M Matrix:");
        Utils.printMatrix(result);
    }

    private void rangeMatrix() {
        double[] x0 = new double[size];
        double[] x1;

        for (int i = 0; i < size; i++) {
            x0[i] = (1.0 / size);
        }

        int i = 1;
        while (true) {
            x1 = Utils.multiplyMatrixByVector(Utils.getMatrixDegree(buildMarkovMatrix(), i), x0);
            i++;
            if (Utils.findNorm(x1, x0) < E){
                break;
            }
            x0 = x1;
        }

        System.out.println("Resulting range:");
        Utils.printVector(x1);
    }
}
