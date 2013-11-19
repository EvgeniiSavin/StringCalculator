/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;
/**
 *
 * @author horch
 */
public class CalculatorImpl {
    
    public String evaluate(String statement) {
        String result = null;
        if(checkCorrectStatement(statement)) {
            result = evaluatePolishNotation(convertToReversePolishNotation(statement));
        }
        return result;
    }

    
    private String evaluatePolishNotation(ArrayList<String> temp_result) {
        
        CheckWithRegexp check = new CheckWithRegexp();
                
        String result = null;
        String temp = null;
        BigDecimal a;
        BigDecimal b;
        int i = 0;

        do {
                 // Check for final result;
             if(temp_result.size() == 1) break;
             
             temp = temp_result.get(i).toString();
             
             if( check.isMathOperators(temp) ) {
                 
                b = new BigDecimal(temp_result.remove(i-1).toString());
                a = new BigDecimal(temp_result.remove(i-2).toString());
                
                if( check.isPlusOperator(temp) ) {                
                    temp_result.set(i-2, a.add(b).toString());
                    i = 0;
                }
                if( check.isMinusOperator(temp) ) {
                    temp_result.set(i-2, a.subtract(b).toString());
                    i = 0;
                }
                if( check.isMultiplicationOperator(temp) ) {                
                    temp_result.set(i-2, a.multiply(b).toString());
                    i = 0;
                }
                if( check.isDivisionOperator(temp) ) {                
                    temp_result.set(i-2, a.divide(b).toString());
                    i = 0;
                }
                
             } else i++;
             
        } while(true);
            
        result = temp_result.get(0).toString();
        return result;
    }
     
    private ArrayList<String> convertToReversePolishNotation(String statement) {
        String temp_num = "";
        String temp_char = "";
        String temp_prev_char = "";
        
        Stack operators_stack = new Stack();
        ArrayList<String> polish_notation = new ArrayList<String>();    
                 
        for(int i = 0; i < statement.length(); i++ ) {
            temp_prev_char = temp_char;
            temp_char = statement.substring(i, i+1);
            
                // Detect number
            if(Pattern.matches("[\\d\\.]", temp_char)) {
                temp_num += temp_char;
                    // If temp_char is last from statement string or next char from is not number, else add temp_num to polish_notation
                if(i + 1 == statement.length() ||  !(Pattern.matches("[\\d\\.]", statement.substring(i+1, i+2))) ) {
                    polish_notation.add(temp_num.toString());
                    temp_num = "";
                }
            } else {
                    // Operators processing
                switch(temp_char.charAt(0)) {
                    
                    case '(':
                            operators_stack.push(temp_char);
                        break;
                        
                    case ')':
                            while(!operators_stack.peek().equals("(")) {
                                polish_notation.add(operators_stack.pop().toString());
                            }
                            operators_stack.pop(); // Delete "(" from operators_stack
                        break;
                    
                    case '-':
                                // "-..." || "...(-..." Situation processing. Convert unary minus (For example: "-2") to binary opeartion ("0-2"). It is need for simplify evaluate.
                            if(temp_prev_char.isEmpty() || temp_prev_char.equals("(")) {
                                polish_notation.add("0");
                                operators_stack.push("-");
                                temp_num = "";
                            } else {
                                while(!(operators_stack.empty())) {
                                    if(!(operators_stack.peek().equals("("))) {
                                        polish_notation.add(operators_stack.pop().toString());
                                    } else break;
                                }
                                temp_num = "";
                                operators_stack.push("-");
                            }
                        break;
                    
                    case '+':
                            while(!operators_stack.empty()) {
                                if(!(operators_stack.peek().equals("("))) {
                                    polish_notation.add(operators_stack.pop().toString());
                                } else break;
                            }
                            operators_stack.push("+");
                        break;
                    
                    case '*':
                            while( !operators_stack.empty() && (operators_stack.peek().equals("*") || operators_stack.peek().equals("/"))) 
                                {
                                    polish_notation.add(operators_stack.pop().toString());
                                }
                            operators_stack.push("*");
                        break;
                    
                    case '/':
                            while( !operators_stack.empty() && (operators_stack.peek().equals("*") || operators_stack.peek().equals("/") )) 
                                {
                                    polish_notation.add(operators_stack.pop().toString());
                                }
                            operators_stack.push("/");
                        break;
                }
            }
        }
        
        if(!operators_stack.empty()) {
            while(!operators_stack.empty()) {
                polish_notation.add(operators_stack.pop().toString());
            }
        }

        return polish_notation;
    }

    private boolean checkCorrectStatement(String statement) {
        
        CheckWithRegexp check = new CheckWithRegexp();
        
        boolean last_operator = false;
        boolean statement_is_correct = true;
        int openingBracket = 0;
        int closeBracket = 0;
        
        String temp;
        
        for(int i = 0; i < statement.length(); i++) {
            temp = "";
            temp += statement.charAt(i);
                // If statement is not correct, then return null
            if(!statement_is_correct) {
                break;
            }
                //If in statement operators is one after another, then statement is not correct
            if( check.isMathOperators(temp) ) {
                if(last_operator) statement_is_correct = false;
                last_operator = true;
            } else {
                last_operator = false;
            }
            
            if( check.isOpeningBracket(temp) ) openingBracket += 1 ;
            if( check.isCloseBracket(temp) ) closeBracket += 1 ;
            
        }
        
            // If sum "(" != sum ")" statement is not correct
        if(statement_is_correct && openingBracket != closeBracket ) {
            statement_is_correct = false;
        }
        
        return statement_is_correct;
    }
}
