/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.calculator;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 * @author horch
 */
public class CalculatorImplTest {
    
    CalculatorImpl calc;
    String tempEvaluate;
    
    String CORRECT_MATH_EXPRESSION_0 = "-(4+6537)*6-(-(-6+21)/5)";
    String CORRECT_MATH_EXPRESSION_1 = "-(-(1-38))+(-102.2+10)*2-(193.2+35)/2";
    String CORRECT_MATH_EXPRESSION_2 = "(1+38)*4-5";
    
    String RESULT_OF_MATH_EXPRESSION_0 = "-39243";
    String RESULT_OF_MATH_EXPRESSION_1 = "-335.5";
    String RESULT_OF_MATH_EXPRESSION_2 = "151";
    
    String INCORRECT_MATH_EXPRESSION_0 = "7*6/(-2)+8";
    
    public CalculatorImplTest() {
    }

    @Before
    public void setup() {
        calc = new CalculatorImpl();
    }
    
    
    /**
     * 
     * Test of evaluate method, of class CalculatorImpl.
     */
    @Test
    public void testCorrectionEvaluate() {
        
        tempEvaluate = calc.evaluate(CORRECT_MATH_EXPRESSION_0);
        assertTrue(tempEvaluate.equals(RESULT_OF_MATH_EXPRESSION_0));
        
        tempEvaluate = calc.evaluate(CORRECT_MATH_EXPRESSION_1);
        assertTrue(tempEvaluate.equals(RESULT_OF_MATH_EXPRESSION_1));
        
        tempEvaluate = calc.evaluate(CORRECT_MATH_EXPRESSION_2);
        assertTrue(tempEvaluate.equals(RESULT_OF_MATH_EXPRESSION_2));
        
    }
    
    @Test
    public void testCorrectBehavourWithIncorectExpression() {
        
        tempEvaluate = calc.evaluate(INCORRECT_MATH_EXPRESSION_0);
        assertNotNull(tempEvaluate);
        
    }
}