package com.calci.main;

public class Number implements IExpression{

	private final int n;
	
	public Number(int n){
		this.n = n;
	}
	public int interpret() {
		return n;
	}

}