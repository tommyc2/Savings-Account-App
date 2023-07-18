package controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.Lodgement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class SavingsAccount {

    private List<Lodgement> lodgements;

    public SavingsAccount() {
        lodgements = new ArrayList<>();
    }

    public boolean addLodgement(Lodgement lodgement) {
        return lodgements.add(lodgement);
    }

    public String listLodgements() {

        String listOfLodgements = "";

        for (Lodgement lodgement : lodgements) {
            listOfLodgements += lodgement.toString();
        }

        if (listOfLodgements.equals("")) {
            return "No Lodgements available.";
        }
        return listOfLodgements;
    }

    public int numberOfPayments() {

        int num = 0;

        for (Lodgement lodgement : lodgements) {
            num += 1;
        }

        return num;

    }

    public double calculateBalance() {
        double balance = 0;

        for (Lodgement lodgement : lodgements) {
            balance = balance + lodgement.getAmount();
        }
        return balance;
    }

    public double calculatePercentageOfGoalCompleted() {
        double balance = calculateBalance();
        return balance / 3250;
    }

    public String displayInsights() {
        String insights = "";

        double balance = calculateBalance();
        double percentCompleted = calculatePercentageOfGoalCompleted() * 100;
        int numberOfLodgements = numberOfPayments();

        // Rounding percentage completed variable to two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double roundedPercentageCompleted = Double.parseDouble(decimalFormat.format(percentCompleted));

        insights += "----- Insights -------\n";
        insights += "| Balance: " + balance + "\n";
        insights += "| % of Goal achieved: " + roundedPercentageCompleted + " %" + "\n";
        insights += "| No. of Lodgements made: " + numberOfLodgements + "\n";
        insights += "-----------------------\n";

        return insights;
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        Class<?>[] classes = new Class[]{Lodgement.class};

        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("savings.xml"));
        lodgements = (ArrayList<Lodgement>) in.readObject();
        in.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("savings.xml"));
        out.writeObject(lodgements);
        out.close();

    }

}
