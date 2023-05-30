package hust.soict.globalict.lab01.DayOfMonth.src;

import javax.swing.JOptionPane;
public class DayOfMonth {
    public static void main(String[] args) {
        int days;
        String monthStr, yearStr;
        int monthNum, year;

        // Get month
        do {
            monthStr = JOptionPane.showInputDialog(null, "Enter a month:");
            monthNum = getMonthNum(monthStr);
        } while (monthNum == -1);

        // Get year
        do {
            yearStr = JOptionPane.showInputDialog(null, "Enter a year:");
            year = getYear(yearStr);
        } while (year == -1);

        days = getDaysInMonth(monthNum, year);
        JOptionPane.showMessageDialog(null, "There are " + days + " days in " + monthStr + " " + year);
        System.exit(0);
    }

    private static int getMonthNum(String monthStr) {
        switch (monthStr.toLowerCase()) {
            case "january":
            case "jan":
            case "jan.":
            case "1":
                return 1;
            case "february":
            case "feb":
            case "feb.":
            case "2":
                return 2;
            case "march":
            case "mar":
            case "mar.":
            case "3":
                return 3;
            case "april":
            case "apr":
            case "apr.":
            case "4":
                return 4;
            case "may":
            case "may.":
            case "5":
                return 5;
            case "june":
            case "jun":
            case "jun.":
            case "6":
                return 6;
            case "july":
            case "jul":
            case "jul.":
            case "7":
                return 7;
            case "august":
            case "aug":
            case "aug.":
            case "8":
                return 8;
            case "september":
            case "sep":
            case "sep.":
            case "9":
                return 9;
            case "october":
            case "oct":
            case "oct.":
            case "10":
                return 10;
            case "november":
            case "nov":
            case "nov.":
            case "11":
                return 11;
            case "december":
            case "dec":
            case "dec.":
            case "12":
                return 12;
            default:
                JOptionPane.showMessageDialog(null, "Invalid month input. Please try again.");
                return -1;
        }
    }

    // Helper method to validate and convert year input to a number
    private static int getYear(String yearStr) {
        try {
            int year = Integer.parseInt(yearStr);
            if (year >= 0) {
                return year;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid year input. Please enter a non-negative number.");
                return -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid year input. Please enter a non-negative number.");
            return -1;
        }
    }

    // Get days inferred from input
    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }
}
