package de.saxsys.dojo.ticketkata;

import java.io.IOException;

/**
 * CinemaCashRegister supports sales transactions for bundles of movie tickets.
 *
 * @author Marco Dierenfeldt
 * @version 0.1
 */
public class CinemaCashRegister {

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

    }

    /**
     * (2) Add a ticket to the customers' bill
     *
     * @param age       the age of the ticket buyer in years
     * @param isStudent true if the ticket buyer is a student
     */
    public void addTicket(int age, boolean isStudent) {
        Person person = new Person(age, isStudent);

    }

    /**
     * (3) Calculate the total purchase price for the current customer(s)
     *
     * @return total in dollars
     */
    public float finishPurchase() {
        return 0.0f;
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

    }

}
