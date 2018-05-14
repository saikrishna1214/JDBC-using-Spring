package org.imaginea.springPractice;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * checks whether all test cases are passed or not
 * prints true if all test cases are passed.
 * otherwise it prints false.
 * @author saikrishnak
 */
public class TestRunner {

	public static void main(String[] args) {
		
		 Result result = JUnitCore.runClasses(AppTest.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }
		
	}

