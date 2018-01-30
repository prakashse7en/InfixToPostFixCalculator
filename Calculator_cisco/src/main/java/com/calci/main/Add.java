package com.calci.main;

public class Add implements IExpression{
	
	private final IExpression leftExpression;
	private final IExpression rightExpression;

	public Add(IExpression leftExpression,IExpression rightExpression ){
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	public int interpret() {
		return leftExpression.interpret() + rightExpression.interpret();
	}

}