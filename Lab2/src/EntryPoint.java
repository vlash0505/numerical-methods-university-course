import methods.AbstractMethod;
import methods.jacobi.JacobiMethod;
import methods.seidel.SeidelMethod;

public class EntryPoint {

    public static void main(String[] args) {
        final double[][] matrix = Utils.buildRandomMatrix();
        final double[][] hilbertMatrix = Utils.buildRandomHilbertMatrix();
        final double[] vectorB = Utils.buildVectorB();

        //for random matrix
        System.out.println("Jacobi method result: ");
        AbstractMethod jacobi = new JacobiMethod(matrix, vectorB);
        System.out.println("Seidel method result: ");
        AbstractMethod seidel = new SeidelMethod(matrix, vectorB);

        //for hilbert matrix
        System.out.println("Jacobi method result: ");
        AbstractMethod jacobiHilbert = new JacobiMethod(hilbertMatrix, vectorB);
        System.out.println("Seidel method result: ");
        AbstractMethod seidelHilbert = new SeidelMethod(hilbertMatrix, vectorB);
    }
}
