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

        if(!isDateValid(day,month,year)){
            throw new IllegalArgumentException(ERR_INVALID_DATE);
        }
        this.year = year;
        this.months = month;
        this.day = day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setYear(int year){
        if (isLeapYear(year))
            this.year = year;
    }

    public void setMonth() {
        this.months = months;
    }
    public void setMonth(Months months) {
        this.months = months;
    }

    public static boolean isLeapYear(int year) {
        return  ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
    public static boolean isDateValid(int day,Months months,int year ){
        return (isLeapYear(year) &&
                months == Months.FEBRUARY &&
                day != 29);
    }
    public static boolean checkMonths(int day, Months months,int year){
        if(months == Months.JANUARY || months == Months.MARCH
                ||months == Months.MAY ||months == Months.JULY ||months == Months.AUGUST
                ||months == Months.OCTOBER ||months == Months.DECEMBER ){
            if(day > 0 && day <= 31)
                return true;
        }
        if(months == Months.APRIL ||months == Months.JUNE
                || months == Months.SEPTEMBER ||months == Months.NOVEMBER)
            if(day > 0 && day <= 30)
                return true;
        if(months == Months.FEBRUARY && isLeapYear(year)){
            
        }
        return false;
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
