package ca.bcit.comp1510.lab08;
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
        // fill this code in and only store a valid date.  
        // throw exception if parameters are not a valid date
    }
    
    public static boolean isMonthValid(int m) {
        return false;
    }
    
    public static boolean isYearValid(int year) {
        return false;
    }
    
    public static boolean isLeapYear(int year) {
        return false;
    }
    
    public static int daysInMonth(int month, boolean isLeapYear) {
        return 0;
    }
    
    public static boolean isDateValid(int day, int month, int year) {
        return false;
    }
    
    public static void main(String[] args) { 
        //date read in from user
        int month, day, year;
        //true if parts of input from user is valid
        boolean monthValid, yearValid, dayValid;  
        //number of days in month read in
        int daysInMonth;
        //true if user's year is a leap year
        boolean leapYear;
        
        Scanner scan = new Scanner(System.in);
        //Get integer month, day, and year from user
        //Use the methods to check to see if month is valid
        //Use the methods to check to see if year is valid
        //Use the methods to determine whether it's a leap year
        //Use the methods to determine number of days in month
        //Use the methods to see if day is valid
        //Use the methods to determine whether date is valid
        //   and print appropriate message
        //Create a Date object with month, day, year
    } 
} 
