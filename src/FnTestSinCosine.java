import functions.*;

public class FnTestSinCosine {
    public static void main( String[] args){
        Function sin = new Sine(Variable.X);
        Function cos = new Cosine(
                new Product (
                        new Sum(
                                Variable.X, new Constant( - 5)), new Constant(  1/3.0)));
        System.out.println(cos.toString());
        System.out.println( "integral of cos: " + cos.integral(0, (3.0 * Math.PI) / 7.0, 10000000));
        System.out.println(sin.toString());
        System.out.println("integral of sin: " + sin.integral( 0, 3 * Math.PI / 2, 10000000));
    }
}
