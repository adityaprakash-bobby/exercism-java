package org.example;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        boolean divisibleBy4 = year % 4 == 0;
        boolean divisibleBy100 = year % 100 == 0;
        boolean divisibleBy400 = year % 400 == 0;

        if (divisibleBy4 && divisibleBy100 && divisibleBy400) return true;
        else if (divisibleBy4 && divisibleBy100) return false;
        else if (divisibleBy4) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] years = {1700, 1900, 2004, 2008, 2020, 2000};
        for (int year : years) {
            System.out.printf("%d year is leap year: %b\n", year, isLeapYear(year));
        }
    }
}
