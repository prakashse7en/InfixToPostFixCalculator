package com.calci.main;

import java.util.EmptyStackException;
import java.util.LinkedList;

class Stack<String>
{
   private LinkedList stack;
   
   public Stack() {
      stack = new LinkedList();
   }
   
   public boolean isEmpty() {
      if(stack.size() == 0)
         return true;
      return false;
   }
   
   public Object push(String o) {
      stack.add(0, o);
      return o;
   }
   
   public Object pop() {
      if(isEmpty())
         throw new EmptyStackException();
      else {
         Object object = stack.getFirst();
         stack.remove(0);
         return object;
      }
   }
   
   public Object peek() {
      if(isEmpty())
         throw new EmptyStackException();
      else {
         Object object = stack.getFirst();
         return object;
      }
   }
}