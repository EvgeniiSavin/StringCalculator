/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StringCalculator;

/**
 *
 * @author horch
 */
public class StringCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CalculatorImpl calc = new CalculatorImpl();
        System.out.println(calc.evaluate("-(4+6537)*6-(-(-6+21)/5)"));
        System.out.println(calc.evaluate("-(-(1-38))+(-102.2+10)*2-(193.2+35)/2"));
        System.out.println(calc.evaluate("(1+38)*4-5"));
        System.out.println(calc.evaluate("7*6/(-2)+8"));
        System.out.println(calc.evaluate("-12)1//("));
    }
}
