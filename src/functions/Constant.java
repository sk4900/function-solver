package functions;

public class Constant extends Function {

    /** value of the constant **/
    public double value;

    /**
     * Creates an instance of a constant
     * @param value value of the constant
     */
    public Constant (double value){
        this.value = value;
    }

    /**
     * Finds the value of a function given the value of x.
     * @param x value of x
     * @return evaluated function with
     */
    public double evaluate(double x) {
        return this.value;
    }

    /**
     * expresses a function as a string
     * @return a string
     */
    public String toString() {
        return Double.toString(this.value);
    }

    /**
     * Finds the derivative of this function
     * @return a function of the derivative
     */
    public Function derivative() {
        return new Constant(0.0);
    }

    /**
     * Finds the integral of this function given the lower and upper bounds
     * @param lower lower bound of the integral
     * @param upper upper bound of the integral
     * @param round the higher the number, the less it's rounded
     * @return the value of the integral
     */
    public double integral(double lower, double upper, double round) {
        double conInt = (upper * this.value) - (lower * this.value);
        return conInt;
    }
}
