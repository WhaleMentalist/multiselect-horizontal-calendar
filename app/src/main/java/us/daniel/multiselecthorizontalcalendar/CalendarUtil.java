package us.daniel.multiselecthorizontalcalendar;

public class CalendarUtil {

    /** The month of 'JAN' starts at index zero */
    public static final String[] MONTH = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
                                            "AUG", "SEP", "OCT", "NOV", "DEC"};

    /** Now this is odd. The day 'SUN' starts at index one. Why? I have no clue. */
    public static final String[] DAY_OF_WEEK = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static String getMonth(int i) {
        return MONTH[i];
    }

    public static String getDayOfWeek(int i) {
        return DAY_OF_WEEK[i - 1]; /* Subtract one due to start index at one */
    }
}
