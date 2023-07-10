package models;

public class SavingsAccount {

    String date = "";
    double balance = 2050.68;
    int weekNumber = 1;
    double target = 3200;

    public SavingsAccount(String date, double balance, int weekNumber) {
        this.date = date;
        this.balance = balance;
        this.weekNumber = weekNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }
}
