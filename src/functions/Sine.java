package functions;

/**
 * the Sine function class
 * @author Sungmin Kim
 */
public class Sine extends Function{

    private Function term;


    public Sine(Function term){
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
        return Math.sin(this.term.evaluate(x));
    }

    /**
     * expresses a function as a string
     *
     * @return a string
     */
    @Override
    public String toString() {
        return ("Sin(" + term.toString() + ")");
    }

    /**
     * Finds the derivative of this function
     *
     * @return a function of the derivative
     */
    @Override
    public Function derivative() {
        return new Cosine( term);
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
        return 0;
    }
}
