package de.saxsys.dojo.ticketkata;

import java.util.ArrayList;

/**
 * CinemaCashRegister supports sales transactions for bundles of movie tickets.
 *
 * @author Marco Dierenfeldt
 * @version 0.1
 */
public class CinemaCashRegister {
    private int runtime;
    private Day day;
    private boolean isParquet;
    private boolean is3D;
    private ArrayList<Ticket> tickets;
    private final float CHILD_PRICE = 5.5f;
    private final float GROUP_PRICE = 6.0f;
    private final float SENIOR_PRICE = 6.0f;
    private final float STUDENT_PRICE = 8.0f;
    private final float GENERAL_PRICE = 11.0f;
    private final int CHILDREN_AGE = 13;
    private final int SENIOR_AGE = 65;

    private final float THREE_D_PRICE = 3.0f;
    private final float LONG_RUNTIME_PRICE = 1.5f;
    private final float THURSDAY_DISCOUNT = 2.0f;
    private final float WEEKEND_PREMIUM = 1.5f;
    private final float SEAT_PRICE = 2.0f;

    private class Ticket{
        private int age;
        private boolean isStudent;
        Ticket(int age, boolean isStudent){
            this.age = age;
            this.isStudent = isStudent;
        }
    }
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
        this.tickets = new ArrayList<Ticket>();
        this.runtime = runtime;
        this.day = day;
        this.isParquet = isParquet;
        this.is3D = is3D;
    }

    /**
     * (2) Add a ticket to the customers' bill
     *
     * @param age           the age of the ticket buyer in years
     * @param isStudent     true if the ticket buyer is a student
     */
    public void addTicket(int age, boolean isStudent) {
        tickets.add(new Ticket(age,isStudent));
    }

    /**
     * (3) Calculate the total purchase price for the current customer(s)
     *
     * @return  total in dollars
     */
    public float finishPurchase() {
        float total = 0.0f;
        boolean isGroupPrice = this.tickets.size() >= 20 ;
        for(Ticket t: this.tickets){
            float price = getTicketPrice(t, isGroupPrice);
            total += price;
        }
        return total;
    }
    public float getTicketPrice(Ticket t, boolean isGroupPrice) {
        float ticketPrice = getAgePrice(t, isGroupPrice);

        if (this.is3D) {
            ticketPrice += THREE_D_PRICE;
        }
        if (this.runtime > 120) {
            ticketPrice += LONG_RUNTIME_PRICE;
        }
        if (this.day == Day.THU && !isGroupPrice) {
            ticketPrice -= THURSDAY_DISCOUNT;
        }
        if (this.day == Day.SAT || this.day == Day.SUN) {
            ticketPrice += WEEKEND_PREMIUM;
        }
        if (!this.isParquet) {
            ticketPrice += SEAT_PRICE;
        }
        return ticketPrice;
    }
    public float getAgePrice(Ticket t, boolean isGroupPrice){
        float ticketPrice = 0.0f;
        if (isGroupPrice) {
            if (t.age < CHILDREN_AGE) {
                ticketPrice = CHILD_PRICE;
            } else {
                ticketPrice = GROUP_PRICE;
            }
        } else {
            if (t.age < CHILDREN_AGE) {
                ticketPrice = CHILD_PRICE;
            } else if (t.age >= SENIOR_AGE) {
                ticketPrice = SENIOR_PRICE;
            } else if (t.isStudent) {
                ticketPrice = STUDENT_PRICE;
            } else {
                ticketPrice = GENERAL_PRICE;
            }
        }
        return ticketPrice;
    }
}

