package com.calci.test;

import org.junit.Test;

import com.calci.exception.InvalidCharacterFound;
import com.calci.main.App;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

	@Test
    public void ptest1(){
		App app = new App();
		try {
			assertEquals("7",app.performCalculation("5+2"));
		} catch (InvalidCharacterFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
    public void ptest2(){
		App app = new App();
		try {
			assertEquals("7",app.performCalculation("5 + 2 * ( 3 / 2)"));
		} catch (InvalidCharacterFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
    public void ptest3(){
		App app = new App();
		try {
			assertEquals("5",app.performCalculation("5 + (2/3) * (3 *(2/3))"));
		} catch (InvalidCharacterFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
    public void ptest4(){
		App app = new App();
		try {
			assertEquals("5",app.performCalculation("5 + (3/2) * (3 *(2/3))"));
		} catch (InvalidCharacterFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
    public void ptest5(){
		App app = new App();
		try {
			assertEquals("29",app.performCalculation("(5*4) + 9"));
		} catch (InvalidCharacterFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test(expected = NullPointerException.class)
    public void ntest1(){
		App app = new App();
		try {
			app.performCalculation(null);
		} catch (InvalidCharacterFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Test(expected = InvalidCharacterFound.class)
    public void ntest2() throws InvalidCharacterFound{
		App app = new App();
			app.performCalculation("a");
    }
	
	@Test(expected = InvalidCharacterFound.class)
    public void ntest3() throws InvalidCharacterFound{
		App app = new App();
			app.performCalculation("a5+7");
    }
	
	@Test(expected = InvalidCharacterFound.class)
    public void ntest4() throws InvalidCharacterFound{
		App app = new App();
			app.performCalculation("abiwq");
    }
	
}
