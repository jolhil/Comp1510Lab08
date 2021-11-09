package ca.bcit.comp1510.lab08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Represent a valid Gregorian date on or after 24 February 1582.
 * @author Jason(Junsang)Yoo
 * @version 2021
 */
public class Date {
    /** day of month.  1 .. max days in month */
    private int day;
    
    /** month of year.  1 .. 12 */
    private int month;
    
    /** year in Gregorian calendar.  1001 .. 2999 */
    private int year;
    
    public Date(int theDay, int theMonth, int theYear) {
        if (isYearValid(theYear)) {
            year = theYear;
        } else {
            throw new IllegalArgumentException("The year is invalid");
        }
        if (isMonthValid(theMonth)) {
            month = theMonth;
        } else {
            throw new IllegalArgumentException("The month is invalid");
        }
        if (isDayValid(theDay, theMonth, theYear)) {
            day = theDay;
        } else {
            throw new IllegalArgumentException("The day is invalid");
        }
    }
    
    public static boolean isDayValid(int day, int month, int year) {
        int days = daysInMonth(month, isLeapYear(year));
        if (days >= day && day > 0) {
            return true;
        }
        return false;
    }
    
    public static boolean isMonthValid(int m) {
        final int twelve = 12;
        if (m >= 1 && m <= twelve) {
            return true;
        }
        return false;
    }
    
    public static boolean isYearValid(int year) {
        final int range1 = 1582;
        final int range2 = 2999;
        if (year >= range1 && year <= range2) {
            return true;
        }
        return false;
    }
    
    public static boolean isLeapYear(int year) {
        final int four = 4;
        final int hundred = 100;
        
        if ((year % (four * hundred)) == 0) {
            return true;
        } else if ((year % hundred) == 0) {
            return false;
        } else if ((year % four) == 0) {
            return true;
        }
        return false;
    }
    
    public static int daysInMonth(int month, boolean isLeapYear) {
        int days = 0;
        final int thirtyOne = 31;
        final int thirty = 30;
        final int twentyEight = 28;
        final int twentyNine = 29;
        
        ArrayList<String> m1 = new ArrayList<String>(Arrays.asList("1", "3",
                 "5", "7", "8", "10", "12"));
        ArrayList<String> m2 = new ArrayList<String>(Arrays.asList("4", "6",
                "9", "11"));
        for (int i = 0; i < m1.size(); i++) {
            if (month == Integer.valueOf(m1.get(i))) {
                days = thirtyOne;
                break;
            }
        }
        for (int i = 0; i < m2.size(); i++) {
            if (month == Integer.valueOf(m2.get(i))) {
                days = thirty;
                break;
            }
        }
        if (isLeapYear && month == 2) {
            days = twentyNine;
        } else if (!isLeapYear && month == 2) {
            days = twentyEight;
        }
        return days;
    }
    
    public static boolean isDateValid(int day, int month, int year) {
        if (isDayValid(day, month, year) && isMonthValid(month)
                && isYearValid(year)) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) { 
        //date read in from user
        int month;
        int day;
        int year;
        
        //true if parts of input from user is valid
        boolean monthValid;
        boolean yearValid;
        boolean dayValid;  
        
        //number of days in month read in
        int daysInMonth;
        
        //true if user's year is a leap year
        boolean leapYear;
        
        Scanner scan = new Scanner(System.in);
        
        //Get integer month, day, and year from user
        System.out.println("Year:");
        year = scan.nextInt();
        System.out.println("Month:");
        month = scan.nextInt();
        System.out.println("Day");
        day = scan.nextInt();
        
        
        //Use the methods to check to see if month is valid
        monthValid = isMonthValid(month);
        if (monthValid) {
            System.out.println("Month is valid");
        } else {
            System.out.println("Month is invalid");
        }
        
        //Use the methods to check to see if year is valid
        yearValid = isYearValid(year);
        if (yearValid) {
            System.out.println("Year is valid");
        } else {
            System.out.println("Year is invalid");
        }
        
        //Use the methods to determine whether it's a leap year
        leapYear = isLeapYear(year);
        if (leapYear) {
            System.out.println("Year is leapyear");
        } else { 
            System.out.println("Year is not leapyear");
        }
        //Use the methods to determine number of days in month
        daysInMonth = daysInMonth(month, isLeapYear(year));
        System.out.println(daysInMonth + " days in the month of the year");
        //Use the methods to see if day is valid
        dayValid = isDayValid(day, month, year);
        if (dayValid) {
            System.out.println("Day is valid");
        } else {
            System.out.println("Day is invalid");
        }
        
        //Use the methods to determine whether date is valid
        //   and print appropriate message
        if (isDateValid(day, month, year)) {
            System.out.println("The date is valid.");
        } else {
            System.out.println("The date is invalid.");
        }
        
        //Create a Date object with month, day, year
        Date date = new Date(day, month, year);
        scan.close();
    } 
} 
