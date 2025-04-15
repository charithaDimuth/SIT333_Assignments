package sit707_tasks;

/**
 * @author Ahsan Habib
 */
public class DateUtil {

    // Months in order 0-11 maps to January-December.
    private static String[] MONTHS = new String[] {
        "January", "February", "March", "April", "May", "June", 
        "July", "August", "September", "October", "November", "December"
    };

    private int day, month, year;

    /*
     * Constructs object from given day, month and year.
     */
    public DateUtil(int day, int month, int year) {
        if (day < 1 || day > 31)
            throw new IllegalArgumentException("Invalid day: " + day + ", expected range 1-31");
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month: " + month + ", expected range 1-12");
        if (year < 1700 || year > 2024)
            throw new IllegalArgumentException("Invalid year: " + year + ", expected range 1700-2024");
        if (day > monthDuration(month, year))
            throw new IllegalArgumentException("Invalid day: " + day + ", max day: " + monthDuration(month, year));
        
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * Increment one day.
     */
    public void increment() {
        if (day < monthDuration(month, year)) {
            day++;
        } else if (month < 12) {
            day = 1;
            month++;
        } else {
            day = 1;
            month = 1;
            year++;
        }
    }

    /**
     * Decrement one day from current date.
     */
    public void decrement() {
        if (day > 1) {
            day--;
        } else if (month > 1) {
            month--;
            day = monthDuration(month, year);
        } else {
            month = 12;
            year--;
            day = monthDuration(month, year);
        }
    }

    /**
     * Calculate duration of current month of year.
     * @param month
     * @param year
     * @return
     */
    public static int monthDuration(int month, int year) {		
        if (month == 2 && year % 4 == 0) {
            return 29; // Leap year
        } else if (month == 2) {  
            return 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;			
        }
        return 31; // All other months
    }

    /**
     * User friendly output.
     */
    public String toString() {
        return day + " " + MONTHS[month - 1] + " " + year;
    }
}