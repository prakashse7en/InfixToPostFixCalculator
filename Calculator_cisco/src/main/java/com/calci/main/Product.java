package com.calci.main;

public class Product implements IExpression{

	private final IExpression leftExpression;
	private final IExpression rightExpression;

	public Product(IExpression leftExpression,IExpression rightExpression ){
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	@Override
	public int interpret() {
		return leftExpression.interpret() * rightExpression.interpret();
	}
}