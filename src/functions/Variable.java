package functions;

public class Variable extends Function {

    public static Variable X = X();
    private Variable(){

    }
    public final static Variable X (){
        X = new Variable();
        return X;
    }

    /**
     * Finds the value of a function given the value of x.
     * @param x value of x
     * @return evaluated function with
     */
    public double evaluate(double x) {
        return x;
    }

    /**
     * expresses a function as a string
     * @return a string
     */
    public String toString() {
        return "X";
    }

    /**
     * Finds the derivative of this function
     * @return a function of the derivative
     */
    public Function derivative() {
        return new Constant(1.0);
    }

    /**
     * Finds the integral of this function given the lower and upper bounds
     * @param lower lower bound of the integral
     * @param upper upper bound of the integral
     * @param round the higher the number, the less it's rounded
     * @return the value of the integral
     */
    public double integral(double lower, double upper, double round) {
        return (upper * upper)/2 - (lower * lower)/2;
    }
}
