package functions;
import java.util.ArrayList;
import java.util.List;

/**
 * Product function
 * @author Sungmin Kim
 */
public class Product extends Function {

    private List<Function> terms;

    /**
     * creates an instance of a product function
     *
     * @param terms terms to be multiplied together
     */
    public Product(Function... terms) {
        this.terms = new ArrayList<>();
        double newConstant = 1.0;
        for (int i = 0; i < terms.length; i++){
            if (terms[i].isConstant()) {
                if( terms[i].evaluate(0) == 1.0){
                    continue;
                }
                newConstant *= terms[i].evaluate(0);
            } else {
                this.terms.add(terms[i]);

            }
        }
        this.terms.add(new Constant(newConstant));
    }

    /**
     * Finds the value of a function given the value of x.
     *
     * @param x value of x
     * @return evaluated function with
     */
    @Override
    public double evaluate(double x) {
        double prodDouble = 1.0;
        for (Function term : this.terms) {
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
        String tStr = "";
        for (Function term : this.terms){
            tStr += term.toString() + " * ";
        }
        tStr = tStr.substring(0, tStr.length() - 3);
        return "( " + tStr + " )";
    }

    /**
     * Finds the derivative of this function
     *
     * @return a function of the derivative
     */
    @Override
    public Function derivative() {
        ArrayList<Function> sumDer = new ArrayList();
        for (int i = 0; i < this.terms.size(); i++) {
            Function[] derivProd = new Function[terms.size()];
            derivProd[i] = this.terms.get(i).derivative();
            for (int j = 0; j < this.terms.size(); j++) {
                if (j != i) {
                    derivProd[j] = this.terms.get(j);
                }
            }
            sumDer.add(new Product(derivProd));
        }
        return new Sum(sumDer.toArray(new Function[sumDer.size()]));
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
