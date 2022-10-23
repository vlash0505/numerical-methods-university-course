package methods.seidel;

import methods.AbstractMethod;

public class SeidelMethod extends AbstractMethod {

    public SeidelMethod(double[][] matrix, double[] vector){
        super(matrix, vector);
        solve();
    }

    public void solve(){
        double[] X0 = new double[N];
        double[] X = new double[N];

        double s;
        double sum;
        double delta;

        do {
            delta = 0;
            s = 0;

            for (int i = 0; i < N; i++) {
                X[i] = vectorB[i];
                for (int j = 0; j < i - 1; j++) {
                    X[i] -= matrix[i][j] * X[j];
                }
                for (int j = i + 1; j < N; j++) {
                    X[i] -= matrix[i][j] * X0[j];
                }
                X[i] /= matrix[i][i];
            }

            for (int i = 0; i < N; i++) {
                delta += Math.abs(X[i] - X0[i]);
                X0[i] = X[i];
            }

            for (int i = 0; i < N; i++) {
                sum = vectorB[i];
                for (int j = 0; j < N; j++) {
                    sum -= matrix[i][j] * X[j];
                }
                s += sum * sum;
            }

            s = Math.sqrt(s);
        }
        while (s > EPS && delta > EPS);

        printResult(X0);
    }
}
