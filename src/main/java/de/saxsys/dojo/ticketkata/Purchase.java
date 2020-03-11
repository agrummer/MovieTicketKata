package de.saxsys.dojo.ticketkata;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private Movie movie;
    private Day day;
    private boolean isParquet;
    private List<Person> people;

    public Purchase(Movie movie, Day day, boolean isParquet) {
        this.movie = movie;
        this.day = day;
        this.isParquet = isParquet;
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public float calcTotalPrice() {
        boolean isGroup = people.size() >= CashRegisterConfig.MIN_GROUP_SIZE;
        float adjustment = calcTicketPriceAdjustment(isGroup);
        float totalPrice = 0.00F;

        for (Person person : people) {
            float ticketPrice = person.calcBaseRate(isGroup) + adjustment;
            totalPrice += ticketPrice;
        }

        return totalPrice;
    }

    private float calcTicketPriceAdjustment(boolean isGroup) {
        float adjustmentAmount = 0.00f;

        for (TicketPriceAdjustment adjustment : CashRegisterConfig.getTicketPriceAdjustments()) {
            if (adjustment.appliesTo(movie, day, isParquet, isGroup)) {
                adjustmentAmount += adjustment.getAmount();
            }
        }

        return adjustmentAmount;
    }
}
