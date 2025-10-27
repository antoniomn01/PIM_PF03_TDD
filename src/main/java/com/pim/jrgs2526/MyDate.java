package com.pim.jrgs2526;

import java.time.Month;

public class MyDate {

    public static final String ERR_INVALID_YEAR = "Year value not valid";
    public static final String ERR_INVALID_MONTH = "Month value not valid";
    public static final String ERR_INVALID_DAY = "Day value not valid";
    public static final String ERR_INVALID_DATE = "Invalid date";

    public int day;
    public int year;
    public Months months;
    public MyDate(){

    }
    public MyDate(int day, Months month, int year) {
        if(year > 0 )
            this.year = year;
        this.months = month;
        this.day = day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setYear(int year){
        this.year = year;
    }

    public void setMonth() {
        this.months = months;
    }
    public void setMonth(Months months) {
        this.months = months;
    }

    public enum Months {
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11),
        DECEMBER(12),
        ERR_INVALID_MONTH(13);

        private int monthNumber;

        private Months(int monthNumber) {
            if(monthNumber < 1 || monthNumber > 12)
                this.monthNumber = 13;
            else {
                this.monthNumber = monthNumber;
            }
        }

        public static Months toMonth( int monthNumber ) {
            for (Months m : values())
                if (m.monthNumber == monthNumber)
                    return m;
            return null;
        }
    }
}
