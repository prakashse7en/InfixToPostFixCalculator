package com.calci.main;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.calci.main.IExpression;
import com.calci.main.ExpressionUtils;
import com.calci.main.Number;

class Calculator {
	private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

	public int cleanandeval(String input) {
		String clean = input.replace(" ", "");
		logger.debug("converting each number and operator into tokens");
		String[] tokens = clean.split("(?<=[-+*/()])|(?=[-+*/()])");
		logger.debug("infix to postfix is performed");
		String[] polish = makePolish(tokens);
		logger.debug("evaluate the expression using stack");
		return evaluate(polish);
	}

	public int evaluate(String[] polishnotation) {
		Stack<String> stack = new Stack<String>();
		for (String token : polishnotation) // Going through everything
			if (!ExpressionUtils.isOperator(token))
				stack.push(token);
			else {
				IExpression number2 = new Number(Integer.parseInt((String) stack.pop()));
				IExpression number1 = new Number(Integer.parseInt((String) stack.pop()));
				IExpression operator = ExpressionUtils.getOperator(token, number1, number2);
				int combine = operator.interpret();
				logger.debug("combine value {}",combine);
				stack.push(String.valueOf(combine));
			}
		return Integer.parseInt((String) stack.pop());
	}

	public String[] makePolish(String[] input) {
		ArrayList<String> polish = new ArrayList<String>(); // This is the final
		Stack<String> inqueue = new Stack<String>();
		logger.debug("infix to postfix starts");
		for (String token : input) {
			if (ExpressionUtils.isOperator(token)) { // Checking operator
				while (!inqueue.isEmpty() && ExpressionUtils.isOperator((String) inqueue.peek())) { // Making
					if (cmpPrecendence(token, (String) inqueue.peek()) <= 0)
						polish.add((String) inqueue.pop());
					break;
				}
				inqueue.push(token);
			} else if (token.equals("(")) { // Parenthesis Check
				inqueue.push(token);
			} else if (token.equals(")")) {
				while (!inqueue.isEmpty() && !inqueue.peek().equals("("))
					polish.add((String) inqueue.pop());
				inqueue.pop();
			} else // Just numbers
				polish.add(token);
		}
		while (!inqueue.isEmpty())
			polish.add((String) inqueue.pop());
		String[] output = new String[polish.size()];
		return polish.toArray(output);
	}

	private int cmpPrecendence(String operator, String operator2) {
		return getPrecendenceValue(operator) - getPrecendenceValue(operator2);
	}

	private int getPrecendenceValue(String operator) {
		if (operator.equals("+"))
			return 2;
		else if (operator.equals("-"))
			return 2;
		else if (operator.equals("*"))
			return 3;
		else if (operator.equals("/"))
			return 3;
		else if (operator.equals("^"))
			return 4;
		else 
			return 0;
	}

}
