package methods;

public abstract class AbstractMethod {

    protected double A;
    protected double B;
    protected double eps;

    public AbstractMethod(double a, double b, double eps) {
        this.A = a;
        this.B = b;
        this.eps = eps;
    }

    public double equation(double x) {
        return Math.pow(x, 2) - 4;
    }

    public void execute() {
        performCalculation();
    }

    public abstract void performCalculation();
}
