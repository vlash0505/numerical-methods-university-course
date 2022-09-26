package methods;

public class NewtonMethod extends AbstractMethod {

    public NewtonMethod(double a, double b, double eps) {
        super(a, b, eps);
    }

    public double firstDerivative(double x) {
        return 2.0 * x;
    }

    public double secondDerivative() {
        return 2.0;
    }

    public void performCalculation(){
        double x0 = A;
        if(!(equation(x0) * secondDerivative() > 0)){
            x0 = B;
            if (!(equation(x0)* secondDerivative() > 0)){
                throw new IllegalArgumentException("Divergence");
            }
        }
        while(Math.abs(equation(x0)) >= 2 * eps){
            x0 -= equation(x0) / firstDerivative(x0);
        }
        System.out.println("x " + x0);
        System.out.println("f(x) " + equation(x0));
    }

}
