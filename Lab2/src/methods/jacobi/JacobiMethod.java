package methods.jacobi;

import methods.AbstractMethod;

public class JacobiMethod extends AbstractMethod {

    public JacobiMethod(double[][] matrix, double[] vector){
        super(matrix, vector);
        solve();
    }

    public void solve(){
        double[] X0 = new double[N];
        double[] X = new double[N];
        double normValue;

        for (int i = 0; i < N; i++) {
            X0[i] = vectorB[i] / matrix[i][i];
        }

        int currentIteration = 0;
        do {
            currentIteration++;
            for (int i = 0; i < N; i++) {
                double sum = 0;
                for (int j = 0; j < N; j++) {
                    if (j == i) {
                        continue;
                    }
                    sum += matrix[i][j] * X0[j];
                }
                X[i] = ((vectorB[i] - sum) / matrix[i][i]);
            }
            System.arraycopy(X, 0, X0, 0, N);

            if (currentIteration > 100){
                throw new IllegalArgumentException("More than 100 iterations are done.");
            }
            normValue = getNormValue(X0, X);
        } while (normValue > EPS);

        printResult(X0);
    }

    private double getNormValue(double[] x1, double[] x2) {
        double sum = 0;
        for(int i = 0; i < N; i++) {
            sum += Math.abs(x1[i] - x2[i]);
        }
        return sum;
    }
}
