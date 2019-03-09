package functions;

import java.util.ArrayList;
import java.util.List;

/**
 * Sum class
 * @author Sungmin Kim
 */
public class Sum extends Function {

    /**
     * list of all terms in the sum function
     */
    private List<Function> terms;

    /**
     * creates a sum function
     * @param terms list of functions to be added
     */
    public Sum(Function... terms) {
        this.terms = new ArrayList<>();
        double newConstant = 0.0;
        for (int i = 0; i < terms.length; i++){
                if (terms[i].isConstant()) {
                    if( terms[i].evaluate(0) == 0.0){
                        continue;
                    }
                    newConstant += terms[i].evaluate(0);
                } else {
                    this.terms.add(terms[i]);
                }
        }
        this.terms.add(new Constant(newConstant));
    }


    /**
     * Finds the value of a function given the value of x.
     * @param x value of x
     * @return evaluated function with
     */
    @Override
    public double evaluate(double x) {
        double sumDouble = 0.0;
        for(Function term : this.terms) {
            sumDouble += term.evaluate(x);
        }
        return sumDouble;
    }

    /**
     * expresses a function as a string
     * @return a string
     */
    @Override
    public String toString() {
        String tStr = "";
        for (Function term : this.terms){
            tStr += term.toString() + " + ";
        }
        tStr = tStr.substring(0, tStr.length()-3);
        return "( " + tStr + " )";
    }

    /**
     * Finds the derivative of this function
     * @return a function of the derivative
     */
    @Override
    public Function derivative() {
        ArrayList<Function> sumDer = new ArrayList();
        for( Function term : this.terms){
                sumDer.add(term.derivative());
            }
        return new Sum(sumDer.toArray(new Function[sumDer.size()]));
    }

    /**
     * Finds the integral of this function given the lower and upper bounds
     * @param lower lower bound of the integral
     * @param upper upper bound of the integral
     * @param round the higher the number, the less it's rounded
     * @return the value of the integral
     */
    @Override
    public double integral(double lower, double upper, double round) {
        double sumInt = 0.0;
        for( Function term : this.terms){
            sumInt += term.integral(lower, upper, round);
        }
        return sumInt;
    }
}
