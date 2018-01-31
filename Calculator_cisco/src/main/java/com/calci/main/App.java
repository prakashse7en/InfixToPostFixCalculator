package com.calci.main;


import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.calci.exception.InvalidCharacterFound;


public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);

   public static void main(String[]args) throws InvalidCharacterFound {
      Scanner scan = new Scanner(System.in);
      App a = new App();
      Calculator calc = new Calculator();
      String yesorno;
      logger.info("type an expression eg) 5+2");
      do {
    	 logger.info("Expression (Don't worry about spaces): ");
         String input = scan.nextLine();
         logger.info("That evaluates to: " +  a.performCalculation(input));
         logger.info("Evaluate another one? (y or n)");
         yesorno = scan.nextLine();
      } while (yesorno.equals("y"));
   }
   
   public String performCalculation(String input) throws InvalidCharacterFound{
	   if(null != input){
		   if(!input.matches(".*[a-zA-Z]+.*")){
			   Calculator calc = new Calculator();
			   return String.valueOf(calc.cleanandeval(input));
		   }else{
			   throw new InvalidCharacterFound("Invalid Characters found");
		   }
	   }else{
		   throw new NullPointerException();
	   }
   }
}


