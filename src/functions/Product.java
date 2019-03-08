package functions;
import java.util.ArrayList;
import java.util.List;

public class Product extends Function{

    private List<Function> terms;

    public Product(Function... terms) {
        for ( Function term : terms) {
            this.terms.add(term);
        }
    }

    /**
     * Finds the value of a function given the value of x.
     *
     * @param x value of x
     * @return evaluated function with
     */
    @Override
    public double evaluate(double x) {
        double prodDouble = 0.0;
        for(Function term : this.terms){
            prodDouble = term.evaluate(x) * prodDouble;
        }
        return prodDouble;
    }

    /**
     * expresses a function as a string
     *
     * @return a string
     */
    @Override
    public String toString() {
        String  tStr = "";
        for( Function term : this.terms){
            tStr.concat(term.toString() + "*");
        }
        return ("(" + "*" + tStr + ")" );
    }

    /**
     * Finds the derivative of this function
     *
     * @return a function of the derivative
     */
    @Override
    public Function derivative() {
        Function[] prodDer = new Function[MAX_TERMS];
        for (int i = 0; i < terms.size() ; i++) {
            Function copy = terms.get(0);
            terms.remove(0);
            terms.add(copy.derivative());
            return copy.derivative();


        }
        return new Constant( 2.0);
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
