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
    public static long daysInMonth ( long month, long year) {
        switch ((int)month) {
            case 1: return 31;
            case 2: if (isLeapYear(year)) {
                        return 29;
                    } else {
                        return 28;
                    }
            case 3: return 31;
            case 4: return 30;
            case 5: return 31;
            case 6: return 30;
            case 7: return 31;
            case 8: return 31;
            case 9: return 30;
            case 10: return 31;
            case 11: return 30;
            case 12: return 31;
            default: return 0;
            }
    }

    /**
     * Returns whether the given date is a valid date.
     */
    public static boolean isValidDate ( long day, long month, long year ) {
        if ( day <= daysInMonth(month, year) && month <= 12 && month > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of days between the two provided dates, regardless of
     * the order they were provided.
     */
    public static long daysBetween ( long day0, long month0, long year0,
            long day1, long month1, long year1 ) {
        long daysInYear0 = 0;
        long daysInYear1 = 0;
        for (int i = 0; i < month0; i++) {
            daysInYear0 = daysInYear0 + daysInMonth(i, year0);
        }
        for (int j = 0; j < month1; j++) {
            daysInYear1 = daysInYear1 + daysInMonth(j, year1);
        }
        daysInYear0 = daysInYear0 + day0 + (year0 * 365);
        daysInYear1 = daysInYear1 + day1 + (year1 * 365);
        return Math.abs(daysInYear0 - daysInYear1);
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
        long day0 = Integer.parseInt(args[0]);
        long month0 = Integer.parseInt(args[1]);
        long year0 = Integer.parseInt(args[2]);
        long day1 = Integer.parseInt(args[3]);
        long month1 = Integer.parseInt(args[4]);
        long year1 = Integer.parseInt(args[5]);
        System.out.println(daysBetween(day0, month0, year0, day1, month1, year1));

    }
}
