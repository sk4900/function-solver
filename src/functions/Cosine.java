package functions;

public class Cosine extends Function {


    private Function term;

    public Cosine (Function term){
        this.term = term;
    }
    /**
     * Finds the value of a function given the value of x.
     *
     * @param x value of x
     * @return evaluated function with
     */
    @Override
    public double evaluate(double x) {
        return Math.cos(this.term.evaluate(x));
    }

    /**
     * expresses a function as a string
     *
     * @return a string
     */
    @Override
    public String toString() {
        return ("Cos(" + term.toString() + ")");
    }

    /**
     * Finds the derivative of this function
     *
     * @return a function of the derivative
     */
    @Override
    public Function derivative() {
        return new Product( new Constant ( -1.0), new Sine ( this.term));
    }

    /**
     * Finds the integral of this function given the lower and upper bounds
     *
     * @param lower lower bound of the integral
     * @param upper upper bound of the integral
     * @param round the higher the number, the less it's rounded
     * @return the value of the integral
     */
    @Override
    public double integral(double lower, double upper, double round) {
        double length = (upper - lower) / round;
        double height = 0.0;
        double area = 0.0;
        for (int i = 0; i < round ; i++){
            area += (((this.evaluate(height) + this.evaluate(height += length))/ 2) * length);
        }
        return area;
    }
}
