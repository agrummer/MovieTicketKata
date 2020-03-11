package de.saxsys.dojo.ticketkata;

/**
 * CinemaCashRegister supports sales transactions for bundles of movie tickets.
 *
 * @author Marco Dierenfeldt
 * @version 0.1
 *
 * This solution was written by Alex Grummer in under an hour
 * (44 minutes to get all unit tests passing and 15 minutes of refactoring to use lambdas)
 *
 */
public class CinemaCashRegister {

    private Purchase purchase;

    /**
     * (1) New customers arrive at your ticket booth and tell you
     * what movie they'd like to see (so keep it in mind ;-)
     *
     * @param runtime   movie's runtime in minutes
     * @param day       day of the week (enum)
     * @param isParquet true if seating category is 'parquet' (and not 'loge')
     * @param is3D      true if the movie's shown in 3D
     */
    public void startPurchase(int runtime, Day day, boolean isParquet, boolean is3D) {
        Movie movie = new Movie(runtime, is3D);
        purchase = new Purchase(movie, day, isParquet);
    }

    /**
     * (2) Add a ticket to the customers' bill
     *
     * @param age       the age of the ticket buyer in years
     * @param isStudent true if the ticket buyer is a student
     */
    public void addTicket(int age, boolean isStudent) {
        purchase.addPerson(new Person(age, isStudent));
    }

    /**
     * (3) Calculate the total purchase price for the current customer(s)
     *
     * @return total in dollars
     */
    public float finishPurchase() {
        return purchase.calcTotalPrice();
    }

}
