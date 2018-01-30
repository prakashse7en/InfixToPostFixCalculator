package com.calci.main;

import java.util.ArrayList;

import com.calci.main.IExpression;
import com.calci.main.ExpressionUtils;
import com.calci.main.Number;

class Calculator
{
   public int cleanandeval(String input) {
      String clean = input.replace(" ", "");
      String[] tokens = clean.split("(?<=[-+*/()])|(?=[-+*/()])");
      String[] polish = makePolish(tokens);
      return evaluate(polish);
   }
   
   public int evaluate(String[] polishnotation) {
      Stack<String> stack = new Stack<String>();
      for(String token : polishnotation) //Going through everything
         if(!ExpressionUtils.isOperator(token))
            stack.push(token);
         else {
            IExpression number2 = new Number(Integer.parseInt((String)stack.pop()));
            IExpression number1 = new Number(Integer.parseInt((String)stack.pop()));
            IExpression operator = ExpressionUtils.getOperator(token, number1,number2);
            int combine = operator.interpret();
           /* int combine;
            if(token.equals("+")) 
               combine = number1 + number2;
            else if(token.equals("-"))
               combine = number1 - number2;
            else if(token.equals("*"))
               combine = number1 * number2;
            else if(token.equals("/"))
               combine = number1 / number2;
            else
               combine = (int)Math.pow(number1, number2);*/
            stack.push(String.valueOf(combine));
         }
      return Integer.parseInt((String)stack.pop());
   }
   
   public String[] makePolish(String[] input) {
      ArrayList<String> polish = new ArrayList<String>(); //This is the final RPN
      Stack<String> inqueue = new Stack<String>(); 
      
      for(String token : input) {
         if(ExpressionUtils.isOperator(token)) { //Checking operator
            while(!inqueue.isEmpty() && ExpressionUtils.isOperator((String)inqueue.peek())) {  //Making sure above
               if(cmpPrecendence(token, (String)inqueue.peek()) <= 0)
                  polish.add((String)inqueue.pop());      
               break;
            }
            inqueue.push(token);
         } else if(token.equals("(")) { //Parenthesis Check
            inqueue.push(token);
         } else if (token.equals(")")) {
            while(!inqueue.isEmpty() && !inqueue.peek().equals("("))
               polish.add((String)inqueue.pop());
            inqueue.pop();
         } else //Just numbers
            polish.add(token);
      }
      
      while(!inqueue.isEmpty())
         polish.add((String)inqueue.pop());
      String[] output = new String[polish.size()];
      return polish.toArray(output);
   }
   
   private int cmpPrecendence(String operator, String operator2) {
      return getPrecendenceValue(operator) - getPrecendenceValue(operator2);
   }
   
   private int getPrecendenceValue(String operator) {
      if(operator.equals("+"))
         return 2;
      else if(operator.equals("-"))
         return 2;
      else if(operator.equals("*"))
         return 3;
      else if(operator.equals("/"))
         return 3;
      else if(operator.equals("^"))
         return 4;
      else //Just return a random value lols
         return 0;  
   }
   
  /* private boolean isoperator(Object input) {
      if(input.equals("+") || input.equals("/") || input.equals("-") || input.equals("*") || input.equals("^"))
         return true;
      return false;
   }*/
}
