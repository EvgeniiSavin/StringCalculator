/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.calculator;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * For test:
 *       "-(4+6537)*6-(-(-6+21)/5)"
 *       "-(-(1-38))+(-102.2+10)*2-(193.2+35)/2"
 *       "(1+38)*4-5"
 *       "7*6/(-2)+8"
 *       "-12)1//("
 * @author horch
 */
public class CalculatorImplTest {
    
    public CalculatorImplTest() {
    }

    /**
     * 
     * Test of evaluate method, of class CalculatorImpl.
     */
    @Test
    public void testCorrectionEvaluateOfEXPRESSION_0() {
        String tempEvaluate;
        CalculatorImpl calc = new CalculatorImpl();
        tempEvaluate = calc.evaluate(ExpressionOfTest.RESULT_OF_MATH_EXPRESSION_0);
        if( tempEvaluate.equals(ExpressionOfTest.CORRECT_MATH_EXPRESSION_0) )
            fail("Evaluate of expression_0 is incorect!");
        
    }
}