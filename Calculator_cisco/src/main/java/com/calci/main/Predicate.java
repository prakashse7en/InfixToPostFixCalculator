package com.calci.main;

@FunctionalInterface
public interface Predicate<T> {
	
	public boolean isOperator(T t);
}
