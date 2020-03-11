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
        float adj = 0.00f;

        // Premiums
        if (movie.is3D()) {
            adj += CashRegisterConfig.THREE_DIMENSIONAL_MOVIE_PREMIUM;
        }
        if (movie.isOverLength()) {
            adj += CashRegisterConfig.OVER_LENGTH_MOVIE_PREMIUM;
        }
        if (Day.SAT.equals(day) || Day.SUN.equals(day)) {
            adj += CashRegisterConfig.WEEKEND_PREMIUM;
        }
        if (!isParquet) {
            adj += CashRegisterConfig.LOGE_SEATING_PREMIUM;
        }

        // Discounts
        if (!isGroup && CashRegisterConfig.MOVIE_DAY.equals(day)) {
            adj -= CashRegisterConfig.MOVIE_DAY_DISCOUNT;
        }

        return adj;
    }
}
