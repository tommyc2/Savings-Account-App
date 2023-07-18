package main;

import controller.SavingsAccount;
import models.Lodgement;
import utils.ScannerInput;

public class Driver {

    private final SavingsAccount savingsAccount = new SavingsAccount();

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.menu();
    }

    private void menu() {
        load();
        System.out.println(savingsAccount.listLodgements());
        System.out.println();

        int option = ScannerInput.readNextInt("""
                ---------------------------
                |  1) Add a lodgement     |
                |  2) View Insights       |
                ---------------------------
                ==>>   """);

        while (option != 0) {

            boolean isAdded = false;

            switch (option) {
                case 1 -> {

                    double amount = ScannerInput.readNextDouble("Enter amount (€): ");
                    int weekNum = ScannerInput.readNextInt("Enter week number: ");
                    int day = ScannerInput.readNextInt("Enter day: ");
                    int month = ScannerInput.readNextInt("Enter month: ");
                    int year = ScannerInput.readNextInt("Enter year: ");

                    Lodgement lodgement = new Lodgement(weekNum, year, month, day, amount);
                    isAdded = savingsAccount.addLodgement(lodgement);

                }
                case 2 -> {
                    System.out.println(savingsAccount.displayInsights());
                }

            }

            if (isAdded) {
                save();
                System.out.println("Lodgement added successfully!");
            } else {
                System.out.println("Lodgement not added");
            }
            ScannerInput.readNextLine("Press enter");
            runMenu();
        }

        System.out.println("Exiting application now...");
        System.exit(0);

    }

    private void runMenu() {
        menu();
    }

    private void save() {
        try {
            savingsAccount.save();
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e);
        }
    }

    private void load() {
        try {
            savingsAccount.load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
    }
}
