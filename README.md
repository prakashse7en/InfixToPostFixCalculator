# InfixToPostFixCalculator

Evaluates a String mathematical expression

*)Run App.java
*)Enter the mathematical expression eg) 5+2 . 7 is returned as output.

*)Various test cases are return on CalculatorTest.java positive and negative test cases.
*)Algorithm
  *)Get expression from user 
  *)Validate the expression
  *)If valid 
    .)split each character number and operators and brackets to array eg ) 5,+,2
    .)process the above array to postfix expression 5,2,+
    .)Create a stack push elements from array in case of operator pop two elements from array eg)in stack 5 and 2 are pushed when + is encountered 5 and 2 are popped 
    .)According to operator encountered operation is performed. eg) + is encountered addition is performed and returned 5+2 =7 is returned
  
  *)Else stop the flow
