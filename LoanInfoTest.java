package uwstout.cs144.labs.lab05;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the LoanInfo class.
 * 
 * @author Flowersc
 * @version 2016-10-19
 */
public class LoanInfoTest {
	
	/**
	 * This test the LoanInfo constructor
	 */
	@Test
	public void testLoanInfo() {
		LoanInfo test = new LoanInfo(301, 10001, 6);
		int credit = test.getCreditScore();
		double loan = test.getAmount();
		int years = test.getYears();

		assertEquals(301, credit);
		assertEquals(10001, loan, 0.001);
		assertEquals(6, years);

		LoanInfo test2 = new LoanInfo(299, 9999, 4);
		int credit2 = test2.getCreditScore();
		double loan2 = test2.getAmount();
		int years2 = test2.getYears();

		assertEquals(300, credit2);
		assertEquals(10000, loan2, 0.001);
		assertEquals(5, years2);

		LoanInfo test3 = new LoanInfo(851, 100001, 10);
		int credit3 = test3.getCreditScore();
		double loan3 = test3.getAmount();
		int years3 = test3.getYears();

		assertEquals(300, credit3);
		assertEquals(100001, loan3, 0.001);
		assertEquals(10, years3);
	}
	
	/**
	 * This tests the canApprove method.
	 */
	@Test
	public void testCanApprove() {
		LoanInfo test4 = new LoanInfo(580, 10000001, 30);
		boolean answer;
		answer = test4.canApprove();

		assertEquals(false, answer);

		LoanInfo test5 = new LoanInfo(670, 5000, 5);
		boolean answer2;
		answer2 = test5.canApprove();

		assertEquals(true, answer2);

		LoanInfo test6 = new LoanInfo(300, 100000, 10);
		boolean answer3;
		answer3 = test6.canApprove();

		assertEquals(false, answer3);

	}
	
	/**
	 * This tests the getInterestRate method.
	 */
	@Test
	public void testGetInterestRate() {
		LoanInfo test7 = new LoanInfo(301, 10001, 10);
		double interestRate;
		interestRate = test7.getInterestRate();

		assertEquals(0.06, interestRate, 0.001);

		LoanInfo test8 = new LoanInfo(301, 10001, 15);
		double interestRate2;
		interestRate2 = test8.getInterestRate();

		assertEquals(0.05, interestRate2, 0.001);

		LoanInfo test9 = new LoanInfo(301, 10001, 30);
		double interestRate3;
		interestRate3 = test9.getInterestRate();

		assertEquals(0.04, interestRate3, 0.001);

		LoanInfo test10 = new LoanInfo(301, 10001, 13);
		double interestRate4;
		interestRate4 = test10.getInterestRate();

		assertEquals(0.08, interestRate4, 0.001);
	}
	
	/**
	 * This tests the getCreditCategory method.
	 */
	@Test
	public void testGetCreditCategory() {
		LoanInfo test11 = new LoanInfo(579, 10001, 6);
		String str;
		str = test11.getCreditCategory();

		assertEquals("Poor", str);

		LoanInfo test12 = new LoanInfo(581, 10001, 6);
		String str2;
		str2 = test12.getCreditCategory();

		assertEquals("Fair", str2);

		LoanInfo test13 = new LoanInfo(671, 10001, 6);
		String str3;
		str3 = test13.getCreditCategory();

		assertEquals("Good", str3);

		LoanInfo test14 = new LoanInfo(799, 10001, 6);
		String str4;
		str4 = test14.getCreditCategory();

		assertEquals("Very Good", str4);

		LoanInfo test15 = new LoanInfo(800, 10001, 6);
		String str5;
		str5 = test15.getCreditCategory();

		assertEquals("Exceptional", str5);
	}
	
	/**
	 * This tests the toString method.
	 */
	@Test
	public void testToString() {
		LoanInfo test16 = new LoanInfo(670, 5000, 5);
		String result;

		result = test16.toString();
		System.out.println(result);
		
		assertEquals(" $10,000.00 @  8% " + 
				"for 5 years, Good credit. Approved", result);
	}

}
