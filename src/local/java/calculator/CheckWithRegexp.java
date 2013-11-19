/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.calculator;

import java.util.regex.Pattern;

/**
 *
 * @author horch
 */
public class CheckWithRegexp {
    
    String expression = null;
    
    public boolean isMathOperators(String expression) {
        return Pattern.matches("[\\-\\+\\*\\/]", expression);
    }
    
    public boolean isOpeningBracket(String expression) {
        return Pattern.matches("\\(", expression);
    }
    
    public boolean isCloseBracket(String expression) {
        return Pattern.matches("\\)", expression);
    }
    
    public boolean isPlusOperator(String expression) {
        return Pattern.matches("\\+", expression);
    }
 
    public boolean isMinusOperator(String expression) {
        return Pattern.matches("\\-", expression);
    }
    
    public boolean isMultiplicationOperator(String expression) {
        return Pattern.matches("\\*", expression);
    }
    
    public boolean isDivisionOperator(String expression) {
        return Pattern.matches("\\/", expression);
    }
    
}
