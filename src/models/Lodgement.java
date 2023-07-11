package models;
import utils.Utilities;

public class Lodgement {

    int year = 2023;
    int month = 1;
    int day = 1;
    int weekNumber = 1;
    double amount = 0;

    public Lodgement(int weekNumber, int year, int month, int day, double amount) {
        setDay(day);
        setMonth(month);
        setWeekNumber(weekNumber);
        setYear(year);
        setAmount(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lodgement lodgement)) return false;
        return year == lodgement.year && month == lodgement.month && day == lodgement.day && weekNumber == lodgement.weekNumber && Double.compare(lodgement.amount, amount) == 0;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        if (amount >= 0){
            this.amount = amount;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year == 2023){
            this.year = year;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (Utilities.validRange(month,1,12)){
            this.month = month;
        }
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        if (Utilities.validRange(day,1,31)){
            this.day = day;
        }
    }
    public int getWeekNumber() {
        return weekNumber;
    }
    public void setWeekNumber(int weekNumber) {
        if (weekNumber > 0){
            this.weekNumber = weekNumber;
        }
    }

    @Override
    public String toString()
    {
        String format = "";

        format += "---- Lodgement ------" + "\n";
        format += "| Date: " + this.day + "/" + this.month + "/" + this.year + "\n";
        format += "| Week: " + this.weekNumber + "\n";
        format += "| Amount: " + this.amount + "\n";
        format += "---------------------\n\n";

        return format;
    }

}
