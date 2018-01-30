package com.calci.main;

public class Substract implements IExpression{
	
	private final IExpression leftExpression;
	private final IExpression rightExpression;

	public Substract(IExpression leftExpression,IExpression rightExpression ){
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	public int interpret() {
		return leftExpression.interpret() - rightExpression.interpret();
	}

}