public class DateDistance {

    /**
     * Returns whether the given year is a leap year.
     */
    public static boolean isLeapYear ( long year ) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns the number of days in the given month in the given year.
     */
    public static long daysInMonth ( long month, long year ) {
        return -1; // TODO: Finish this method!
    }

    /**
     * Returns whether the given date is a valid date.
     */
    public static boolean isValidDate ( long day, long month, long year ) {
        return false; // TODO: Finish this method!
    }

    /**
     * Returns the number of days between the two provided dates, regardless of
     * the order they were provided.
     */
    public static long daysBetween ( long day0, long month0, long year0,
            long day1, long month1, long year1 ) {
      return -1; // TODO: Finish this method!
    }

    /**
     * Returns the day of the week the given date occured on as a String.
     */
    public static String dayOfTheWeek ( long day, long month, long year ) {
        return ""; // TODO: Finish this method!
    }

    /**
     * Returns the long form of the given date as a String.
     */
    public static String longformDate ( long day, long month, long year ) {
        return ""; // TODO: Finish this method!
    }

    public static void main ( String[] args ) {
        long year = Integer.parseInt(args[0]);
        System.out.println(isLeapYear(year));
    }
}
