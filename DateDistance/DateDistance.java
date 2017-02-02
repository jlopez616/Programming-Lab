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
        if ( day <= daysInMonth(month, year) && day > 0 && month <= 12
        && month > 0 && year > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of days between the two provided dates, regardless of
     * the order they were provided.
     */

    public static boolean isBigger(long valueOne, long valueTwo) {
        if (valueOne > valueTwo) {
            return true;
        } else {
            return false;
        }
    }

    public static long totalDays(long day, long month, long year) {
        long totalDaysInYear = 0;
        for (int i = 0; i < month; i++) {
            totalDaysInYear = totalDaysInYear + daysInMonth(i, year);
        }
        return totalDaysInYear + day;
    }



    public static long daysBetween ( long day0, long month0, long year0,
            long day1, long month1, long year1 ) {
        long daysInBetween = 0;
        if (isBigger(year0, year1) || isBigger(totalDays(day0, month0, year0),
            totalDays(day1, month1, year1))) {
                if ((year0 > year1) || (year0 == year1)) {
                    long tempDay = day0;
                    long tempMonth = month0;
                    long tempYear = year0;
                    day0 = day1;
                    month0 = month1;
                    year0 = year1;
                    day1 = tempDay;
                    month1 = tempMonth;
                    year1 = tempYear;
                }
            }

        while ((year0 < year1) || (month0 < month1) || (day0 < day1)) {
            day0++;
            daysInBetween++;
            while (day0 > daysInMonth(month0, year0)) {
                day0 = 1;
                month0++;
                while (month0 > 13) {
                    year0++;
                    month0 = 1;
                    day0 = 1;
                    }
                }
            }
        return daysInBetween;
        }
    /**
     * Returns the day of the week the given date occured on as a String.
     */
    public static String dayOfTheWeek ( long day, long month, long year ) {
        long start = 0;

        start = daysBetween(day, month, year, 1, 1, 1970);
        if (year < 1970) {
            start = start % 7;
            start = 6 - start + 1;
            if (start > 6) {
                start = 0;
            }

        } else {
            start = start % 7;
        }
        switch((int)start) {

            case 0: return "Thursday";
            case 1: return "Friday";
            case 2: return "Saturday";
            case 3: return "Sunday";
            case 4: return "Monday";
            case 5: return "Tuesday";
            case 6: return "Wednesday";
            default: return "Invalid Date!";
        }
    }

    /**
     * Returns the long form of the given date as a String.
     */
    public static String monthString (long month) {
        switch((int)month) {
            case 1: return "January";
            case 2: return "February";
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
            return dayOfTheWeek(day, month, year) + ", " + day + " "
            + monthString(month) + " " + year; // TODO: Finish this method!
    }

    public static String plural(long daysBetween) {
        if (daysBetween != 1) {
            return "are " + daysBetween + " days ";
        } else {
            return "is 1 day ";
        }
    };

    public static void main ( String[] args ) {
        long day0 = Integer.parseInt(args[0]);
        long month0 = Integer.parseInt(args[1]);
        long year0 = Integer.parseInt(args[2]);
        long day1 = Integer.parseInt(args[3]);
        long month1 = Integer.parseInt(args[4]);
        long year1 = Integer.parseInt(args[5]);
        System.out.println("There " +
        plural(daysBetween(day0, month0, year0, day1, month1, year1))
        + "between " + longformDate(day0, month0, year0) + " and " +
        longformDate(day1, month1, year1));

    }
}
