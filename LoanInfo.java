package uwstout.cs144.labs.lab05;

import java.text.NumberFormat;

/**
 * This class presents information to a bank for a possible loan.
 * 
 * @author Flowersc
 * @version 2016-10-18
 */
public class LoanInfo {
	private int credit;
	private double loan;
	private int years;
	// constants

	/**
	 * This constant is for the interest rate when the loan is for 10 years.
	 * 
	 */
	private static final double INT_RATE_1 = 0.06;

	/**
	 * This constant is for the interest rate when the loan is for 15 years.
	 * 
	 */
	private static final double INT_RATE_2 = 0.05;

	/**
	 * This constant is for the interest rate when the loan is for 30 years.
	 * 
	 */
	private static final double INT_RATE_3 = 0.04;

	/**
	 * This constant is for the interest rate when the loan is for any other
	 * amount of years.
	 * 
	 */
	private static final double INT_RATE_4 = 0.08;

	/**
	 * This constant is the minimum value for a loan.
	 * 
	 */
	private static final double MIN_LOAN = 10000;

	/**
	 * This constant is the maximum value for a loan.
	 * 
	 */
	private static final double MAX_LOAN = 100000;

	/**
	 * This constant is the minimum value for the amount of years for a loan.
	 * 
	 */
	private static final int MIN_YEARS = 5;

	/**
	 * This constant is the minimum value for a person's credit.
	 * 
	 */
	private static final int MIN_CREDIT = 300;

	/**
	 * This constant is the maximum value for a person's credit.
	 * 
	 */
	private static final int MAX_CREDIT = 850;

	/**
	 * This constant is the credit category for someone with less than 580
	 * credit.
	 * 
	 */
	private static final String POOR = "Poor";

	/**
	 * This constant is the credit category for someone with less than 670
	 * credit.
	 * 
	 */
	private static final String FAIR = "Fair";

	/**
	 * This constant is the credit category for someone with less than 740
	 * credit.
	 * 
	 */
	private static final String GOOD = "Good";

	/**
	 * This constant is the credit category for someone with less than 780
	 * credit.
	 * 
	 */
	private static final String VERY_GOOD = "Very Good";

	/**
	 * This constant is the credit category for someone with a credit score more
	 * than 780.
	 * 
	 */
	private static final String EXCEPTIONAL = "Exceptional";

	// constructor

	/**
	 * This constructor checks to see if the credit score, amount and years are
	 * valid.
	 * 
	 * @param nCredit
	 *            this is the users credit score
	 * @param nLoan
	 *            this is the amount of the loan
	 * @param nYears
	 *            this is the amount of years
	 */
	public LoanInfo(int nCredit, double nLoan, int nYears) {
		credit = Math.max(nCredit, 300);
		loan = nLoan;
		years = nYears;
		// evaluating credit
		if (credit < MIN_CREDIT || credit > MAX_CREDIT) {
			credit = MIN_CREDIT;
		} 
		// evaluating loan amount
		if (loan < MIN_LOAN) {
			loan = MIN_LOAN;
		}
		// evaluating years
		if (years < MIN_YEARS) {
			years = MIN_YEARS;
		}
	}

	// getters

	/**
	 * This getter gets the credit score.
	 * 
	 * @return the credit score
	 */
	public int getCreditScore() {
		return credit;
	}

	/**
	 * This getter gets the loan amount.
	 * 
	 * @return the amount the loan is for
	 */
	public double getAmount() {
		return loan;
	}

	/**
	 * This getter gets the number of years.
	 * 
	 * @return the amount of years the loan is for
	 */
	public int getYears() {
		return years;
	}

	// method canApprove

	/**
	 * This method evaluates the credit and amount of loan and determines if it
	 * is approved or denied.
	 * 
	 * @return if the loan is approved or denied
	 */
	public boolean canApprove() {
		boolean approved;
		if (credit >= 670 || (credit >= 580 && loan < MAX_LOAN)) {
			approved = true;
		}
		else {
			approved = false;
		}
		//approved = (credit >= 670 || (credit >= 580 && loan < MAX_LOAN));
		return approved;
	}
	// method getInterestRate

	/**
	 * This method gets the interest rate for a loan. 
	 * 
	 * @return the interest rate for the loan
	 */
	public double getInterestRate() {
		double interestRate;

		switch (years) {
		case 10:
			interestRate = INT_RATE_1;
			break;
		case 15:
			interestRate = INT_RATE_2;
			break;
		case 30:
			interestRate = INT_RATE_3;
			break;
		default:
			interestRate = INT_RATE_4;
			break;
		}

		return interestRate;
	}
	// method getCreditCategory

	/**
	 * This method determines the category that a certain amount of credit is.
	 * 
	 * @return the category that the credit is defined as
	 */
	public String getCreditCategory() {
		String str;

		if (credit < 580) {
			str = POOR;
		} else {
			if (credit < 670) {
				str = FAIR;
			} else {
				if (credit < 740) {
					str = GOOD;
				} else {
					if (credit < 800) {
						str = VERY_GOOD;
					} else {
						str = EXCEPTIONAL;
					}
				}
			}
		}

		return str;
	}

	/**
	 * This method prints out the entire data for the loan.
	 * 
	 * @return String value of the results.
	 */
	public String toString() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();
		String result;
		String money;
		String rate;
		String time;
		String type;
		String approval;
		LoanInfo myLoan;
		myLoan = new LoanInfo(credit, loan, years);
		money = " " + currency.format(myLoan.getAmount());
		rate = " " + percent.format(myLoan.getInterestRate());
		time = " " + years;
		type = " " + myLoan.getCreditCategory();
		if (myLoan.canApprove()) {
			approval = "Approved";
		}
		else {
			approval = "Denied";
		}
		result = money + " @ " + rate + " for" + 
				time + " years," + type + " credit. " + approval;
		return result;

	}

}