package exercises;

public final class LoanInfo {
	private long amountBorrowedIncents; 
	private double apr; 
	private int initialTermMonths;
	private double monthlyInterest;
	private long monthlyPaymentAmountIncents;
	
	private final static double MONTHLY_INTEREST_DIVISOR = 12d * 100d;
	
	public LoanInfo(long aAmountBorrowedIncents, double aApr, int aInitialTermMonths) {
		amountBorrowedIncents = aAmountBorrowedIncents;
		apr = aApr;
		initialTermMonths = aInitialTermMonths;
		monthlyInterest = apr/MONTHLY_INTEREST_DIVISOR;
		monthlyPaymentAmountIncents = getMonthlyPayment();
	}

	public long getAmountBorrowedIncents() {
		return amountBorrowedIncents;
	}

	public double getApr() {
		return apr;
	}

	public int getInitialTermMonths() {
		return initialTermMonths;
	}
	
	public double getMonthlyInterest() {
		return monthlyInterest;
	}
	
	public long getMonthlyPaymentAmountIncents() {
		return monthlyPaymentAmountIncents;
	}
	
	
	/**
	 * The basic formula is M = P * (J / (1 - (Math.pow(1/(1 + J), N)))).
	 * P is Principal in cents
	 * J is Monthly Interest in decimal form: I / (12 * 100)
	 * N is Number of months of loan
	 * M is Monthly Payment Amount
	 * @return Monthly Payment Amount in Cents
	 */
	private long getMonthlyPayment() {
		// this is 1 / (1 + J)
		double tmp = Math.pow(1d + monthlyInterest, -1);
		// this is Math.pow(1/(1 + J), N)
		tmp = Math.pow(tmp, initialTermMonths);
		// this is 1 / (1 - (Math.pow(1/(1 + J), N))))
		tmp = Math.pow(1d - tmp, -1);
		// M = P * (J / (1 - (Math.pow(1/(1 + J), N))));
		double rc = amountBorrowedIncents * monthlyInterest * tmp;
		return Math.round(rc);
	}
	
}
