import methods.AbstractMethod;
import methods.DichotomyMethod;
import methods.NewtonMethod;
import methods.RelaxationMethod;

public class EntryPoint {

    public static void main(String[] args) {
        System.out.println("Dichotomy method");
        AbstractMethod dichotomyMethod = new DichotomyMethod(0, 5, 0.0001);
        dichotomyMethod.execute();
        System.out.println();

        System.out.println("Newton method");
        AbstractMethod newtonMethod = new NewtonMethod(0, 5, 0.0001);
        newtonMethod.execute();
        System.out.println();

        System.out.println("Relaxation method");
        AbstractMethod relaxationMethod = new RelaxationMethod(0, 5, 0.0001);
        relaxationMethod.execute();
    }
}
