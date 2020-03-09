package de.saxsys.dojo.ticketkata;

import java.util.*;
/**
 * CinemaCashRegister supports sales transactions for bundles of movie tickets.
 *
 * @author Marco Dierenfeldt
 * @version 0.1
 */
public class CinemaCashRegister {

    ArrayList<Ticket> ticketsSold;
    boolean isParquet;
    boolean is3D;
    Day day;
    int runtime;

    /**
     * (1) New customers arrive at your ticket booth and tell you
     * what movie they'd like to see (so keep it in mind ;-)
     *
     * @param runtime       movie's runtime in minutes
     * @param day           day of the week (enum)
     * @param isParquet     true if seating category is 'parquet' (and not 'loge')
     * @param is3D          true if the movie's shown in 3D
     */
    public void startPurchase(int runtime, Day day, boolean isParquet, boolean is3D) {
        ticketsSold = new ArrayList();
        this.isParquet = isParquet;
        this.is3D = is3D;
        this.day = day;
        this.runtime = runtime;

    }

    /**
     * (2) Add a ticket to the customers' bill
     *
     * @param age           the age of the ticket buyer in years
     * @param isStudent     true if the ticket buyer is a student
     */
    public void addTicket(int age, boolean isStudent) {
        Ticket newTicket = new Ticket(age, isStudent);
        ticketsSold.add(newTicket);
    }

    /**
     * (3) Calculate the total purchase price for the current customer(s)
     *
     * @return  total in dollars
     */
    public float finishPurchase() {

        float totalPrice = 0.0F;
        boolean isGroupPrice = ticketsSold.size() >= 20;
        for (int x = 0; x < ticketsSold.size(); x++) {
            Ticket ticket = ticketsSold.get(x);
            totalPrice = totalPrice + calculateTicketPrice(ticket.age, ticket.isStudent, isParquet, is3D, day, isGroupPrice);
        }

        //return 0.0f;
        return totalPrice;
    }

    private float calculateTicketPrice(int age, boolean isStudent, boolean isParquet,  boolean is3D, Day day, boolean isGroupPrice) {

        float price = 11.0F; // general admission price for all ages

        if (isGroupPrice) {
            price = 6.0F;
        } else if (isStudent) {
            price = 8.0F;
        }


            // modify based on age of person
            if (age >= 65) {
                price = 6.0F;
            }

            if (age < 13) {
                price = 5.5F;
            }

            // check movie length
            if (runtime > 120){
                price = price + 1.5F;
            }
            //

            // deal with pricing exceptions per movie criteria
            if (!isParquet) {
                price = price + 2.0F;
            }

            // modify based on moview format
            if (is3D) {
                price = price + 3.0F;
            }

            // modify based on day of week
            if (day == Day.THU && !isGroupPrice) {
                price = price - 2.0F;
            }

            if (day == Day.SAT || day == Day.SUN) {
                price = price + 1.5F;
            }

            return price;
        }

}
