package methods.gaussian;

import methods.AbstractMethod;

public class GaussMethod extends AbstractMethod {

    public GaussMethod(double[][] matrix, double[] vectorB) {
        super(matrix, vectorB);
    }

    public void solve(){
        int N = vectorB.length;
        for (int k = 0; k < N; k++) {
            int max = k;
            for (int i = k + 1; i < N; i++) {
                if (Math.abs(matrix[i][k]) > Math.abs(matrix[max][k])) {
                    max = i;
                }
            }

            swapRows(k, max);
            swapInVector(k, max);

            for (int i = k + 1; i < N; i++) {
                double factor = matrix[i][k] / matrix[k][k];
                vectorB[i] -= factor * vectorB[k];
                for (int j = k; j < N; j++) {
                    matrix[i][j] -= factor * matrix[k][j];
                }
            }
        }
        buildResult();
    }

    private void swapRows(int k, int max) {
        double[] temp = matrix[k];
        matrix[k] = matrix[max];
        matrix[max] = temp;
    }

    private void swapInVector(int k, int max) {
        double t = vectorB[k];
        vectorB[k] = vectorB[max];
        vectorB[max] = t;
    }

    private void buildResult() {
        double[] result = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += matrix[i][j] * result[j];
            }
            result[i] = (vectorB[i] - sum) / matrix[i][i];
        }
        printResult(result);
    }
}
