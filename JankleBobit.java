/***********************************************************
 * Name: Evan Correia
 * Date: 1/31/23
 * Description of lab work: This lab had us make a calendar that would progress by one day, 
 * changing specifically at the end of days in a month or months in a year.
 ***********************************************************/


public class JankleBobit {
    private int month;
    private int day;
    private int year;

    public JankleBobit() {
        month = 1;
        day = 1;
        year =2006;
    }

    public JankleBobit (int m, int d, int y){
        month = m;
        day = d;
        year =y;
    }

    // -----------------------------------------------------------------------------
    // Check if a date is valid.
    // Preconditon: m, d and y are integers.
    // Postcondtion: If the combination of m, d and y represents a valid date,
    //       a true value is returned; otherwise, a false value is returned.
    // -----------------------------------------------------------------------------
    public static boolean isLegitimate(int m, int d, int y){
    	
    	/*
    	 * The Jankle Bobit calendar has the following properties:
		- A whopping total of 17 months in a year.
		- The months have no names, but rather just numbers. 1 is the first month, 2 is the second
		month, 3 is the third month, and so on.
		- Every even numbered month has 14 days
		- Every odd numbered month has 45 days
		- Even numbered years are leap years where month 6 has an extra day (15 days).
    	 */
        
    	// Special check for leap years
    	if(y%2 == 0 && m == 6) {
        	if (d > 15) {
        		return false;
        	}
            return true;
    	}
    	// Checks if month is valid
    	if(m < 1 || m > 17) {
    		return false;
    	}
    	// Checks if even month days are valid
    	if (m % 2 == 0 && d > 14) {
    		return false;
    	}
    	// Checks if odd month days are valid
    	if (m % 2 == 1 && d > 45) {
    		return false;
    	}
    	// Checks if year is valid
    	if (y < 0) {
    		return false;
    	}
    	
        return true;
    }

    // -----------------------------------------------------------------------------
    // Advance a given date by one day
    // Preconditon: givenDate is a valid date
    // Postcondtion: givenDate is a new valid date that is increased by one day
    // -----------------------------------------------------------------------------
    public static void advanceDate(JankleBobit givenDate) {


        // TODO 2: Implement this method to advance aDate by one day.
    	// Moves day up by one
    	givenDate.day++;
    	// Checks if date is legitimate
    	if (!isLegitimate(givenDate.month, givenDate.day, givenDate.year)) {
    		// Sets date for next month and resets day
    		givenDate.day = 01;
    		givenDate.month++;
    		// Checks if date is legitimate
    		if (!isLegitimate(givenDate.month, givenDate.day, givenDate.year)) {
    			// Sets date for next year and resets month
        		givenDate.month = 01;
        		givenDate.year++;
        		// Checks if date is legitimate (should be by now)
        		if (!isLegitimate(givenDate.month, givenDate.day, givenDate.year)) {
            		System.out.println("Coder messed up somewhere... So you found a new bug! Yay.....");
            	}
        	}
    	}
    }

    public void display(String s){
        System.out.println(s + month + "/" + day + "/" + year);
    }
}
