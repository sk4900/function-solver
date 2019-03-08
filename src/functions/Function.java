package functions;

/**
 * abstract class extended by all functions
 * @author Sungmin Kim
 */
public abstract class Function {

    public static final int MAX_TERMS = 10;

    /**
     * Finds the value of a function given the value of x.
     * @param x value of x
     * @return evaluated function with
     */
    public abstract double evaluate( double x);

    /**
     * expresses a function as a string
     * @return a string
     */
    public abstract String toString();

    /**
     * Finds the derivative of this function
     * @return a function of the derivative
     */
    public abstract Function derivative();

    /**
     * Finds the integral of this function given the lower and upper bounds
     * @param lower lower bound of the integral
     * @param upper upper bound of the integral
     * @param round the higher the number, the less it's rounded
     * @return the value of the integral
     */
    public abstract double integral(double lower, double upper, double round);

    /**
     * Checks if current function is a constant or not
     * @return true if this is a constant
     */
    public boolean isConstant(){
        return (this instanceof Constant);
    }

}