package de.saxsys.dojo.ticketkata;

import java.io.IOException;
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

    List<Purchase> purchases = new ArrayList<>();

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
        Purchase purchase = new Purchase(movie, day, parquet);
        purchases.add(purchase);
    }

    /**
     * (2) Add a ticket to the customers' bill
     *
     * @param age       the age of the ticket buyer in years
     * @param isStudent true if the ticket buyer is a student
     */
    public void addTicket(int age, boolean isStudent) {
        Person person = new Person(age, isStudent);
        getCurrentPurchase().addPerson(person);
    }

    /**
     * (3) Calculate the total purchase price for the current customer(s)
     *
     * @return total in dollars
     */
    public float finishPurchase() {
        return getCurrentPurchase().calcTotalPrice();
    }

    /**
     * (4 - OPTIONAL) Extra credit:
     *
     * Write a CSV file to disk with the current date for a name (ex: 2000-01-31.csv)
     * The CSV file should include:
     *   - Human-readable column headers
     *   - One row for each purchase transaction
     *   - Total sales revenue as the last row
     */
    public void writeAllPurchasesToCSV() throws IOException {
        List<String[]> rows = new ArrayList<>();
        rows.add(new String[]{"Day", "Movie", "Tickets", "Total"});
        int totalTickets = 0;
        float totalSalesRevenue = 0.0f;
        for (Purchase purchase : purchases) {
            Day day = purchase.getDay();
            String movieTitle = purchase.getMovie().getTitle();
            int tickets = purchase.getPeople().size();
            float purchasePrice = purchase.calcTotalPrice();
            rows.add(new String[]{day.name(), movieTitle, String.valueOf(tickets), NumberFormat.getCurrencyInstance().format(purchasePrice)});
            totalTickets += tickets;
            totalSalesRevenue += purchasePrice;
        }
        rows.add(new String[]{"", "Total Sales Revenue", String.valueOf(totalTickets), NumberFormat.getCurrencyInstance().format(totalSalesRevenue)});

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String filename = dateFormat.format(new Date()) + ".csv";
        CsvUtil.writeToCsvFile(filename, rows);
    }

    private Purchase getCurrentPurchase() {
        return purchases.get(purchases.size() - 1);
    }

}
