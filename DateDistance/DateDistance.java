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
}
        daysInYear0 = daysInYear0 + day0 + (year0 * 365);
        daysInYear1 = daysInYear1 + day1 + (year1 * 365);
        return Math.abs(daysInYear0 - daysInYear1);
    }

//determine which goes first
//eitehr recursively or with loop, make the bigger one go down by one
//keep track of how many days you take away
    /**
     * Returns the day of the week the given date occured on as a String.
     */
    public static String dayOfTheWeek ( long day, long month, long year ) {
        long dOTW = (day + ((13 * (month + 1)) / 5) + (year % 100) + ((year % 100)/4) + ((year/100)/4) + (5 * (year/100))) % 7;
        switch((int)dOTW) {
            case 0: return "Saturday";
            case 1: return "Sunday";
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            case 6: return "Friday";
            default: return "Invalid Date!";
        }
    }

    /**
     * Returns the long form of the given date as a String.
     */
    public static String monthString (long month) {
        switch((int)month) {
            case 1: return "January";
            case 2: return "Feburary";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid Date!";
        }
    }
    public static String longformDate ( long day, long month, long year ) {
            return dayOfTheWeek(day, month, year) + ", " + day + " " + monthString(month) + " " + year; // TODO: Finish this method!
    }

    public static void main ( String[] args ) {
        long day = Integer.parseInt(args[0]);
        long month = Integer.parseInt(args[1]);
        long year = Integer.parseInt(args[2]);
//        long day1 = Integer.parseInt(args[3]);
//        long month1 = Integer.parseInt(args[4]);
//        long year1 = Integer.parseInt(args[5]);
        System.out.println(longformDate(day, month, year));

    }
}
