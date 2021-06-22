package de.saxsys.dojo.ticketkata;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CinemaCashRegister supports sales transactions for bundles of movie tickets.
 *
 * @author Marco Dierenfeldt
 * @version 0.1
 */
public class CinemaCashRegister {

    private Purchase purchase;
    private List<Purchase> purchaseList = new ArrayList<>();
    /**
     * (1) New customers arrive at your ticket booth and tell you
     * what movie they'd like to see (so keep it in mind ;-)
     *
     * @param movieTitle   title of the film
     * @param movieRuntime movie's runtime in minutes
     * @param day          day of the week (enum)
     * @param parquet      true if seating category is 'parquet' (and not 'loge')
     */
    public void startPurchase(String movieTitle, int movieRuntime, Day day, boolean parquet) {
        Movie movie = new Movie(movieTitle, movieRuntime);
        purchase = new Purchase(movie, day, parquet);

    }

    //group ticket - Count number of people
    /**
     * (2) Add a ticket to the customers' bill
     *
     * @param age       the age of the ticket buyer in years
     * @param isStudent true if the ticket buyer is a student
     */
    public void addTicket(int age, boolean isStudent) {
        Person person = new Person(age, isStudent);
        purchase.addPerson(person);

    }

    //group pricing based on number of tickets
    /**
     * (3) Calculate the total purchase price for the current customer(s)
     *
     * @return total in dollars
     */
    public float finishPurchase() {
        //calculate total price
        purchaseList.add(purchase);
        return purchase.calcTotalPrice();
    }

    /**
     * (4) Generate CSV
     *
     * Write a CSV file to disk with the current date for a name (ex: 2000-01-31.csv)
     * The CSV file should include:
     *   - Human-readable column headers
     *   - One row for each purchase transaction
     *   - Total sales revenue as the last row
     */
    public void writeAllPurchasesToCSV() throws IOException {
        //Build header
        String header = "Movie, Day, Tickets Sold, Total\n";
        StringBuilder output = new StringBuilder(header);

        //purchases
        float total = 0;
        int totalTickets = 0;
        for(final Purchase purchase : purchaseList) {
            total += purchase.calcTotalPrice();
            totalTickets += purchase.getPeople().size();
            output.append(generatePurchaseRow(purchase));
        }

        //final row
        String finalRow = "Total, ,"+ totalTickets+", "+ dollarOutput(total) + "\n";
        output.append(finalRow);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        File file = new File(dateFormat.format(date)+".csv");
        file.createNewFile();
        PrintWriter writer = new PrintWriter(file);
        writer.write(output.toString());

        writer.close();
    }

    private String generatePurchaseRow(final Purchase purchase) {
        StringBuilder purchaseRow = new StringBuilder();

        //Title
        purchaseRow.append(purchase.getMovie().getTitle()+",");
        //Day
        purchaseRow.append(purchase.getDay().name()+",");
        //tickets sold
        purchaseRow.append(purchase.getPeople().size()+",");
        //total price
        purchaseRow.append(dollarOutput(purchase.calcTotalPrice()) + "\n");

        return purchaseRow.toString();
    }

    private String dollarOutput(float dollars) {
        return NumberFormat.getCurrencyInstance().format(dollars);
    }
}
