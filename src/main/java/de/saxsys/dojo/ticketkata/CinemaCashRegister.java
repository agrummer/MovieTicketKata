package de.saxsys.dojo.ticketkata;

import java.util.ArrayList;

/**
 * CinemaCashRegister supports sales transactions for bundles of movie tickets.
 *
 * @author Marco Dierenfeldt
 * @version 0.1
 */
public class CinemaCashRegister {
    private static final float CHILD_PRICE = 5.50f;
    private static final float SENIOR_PRICE = 6.0f;
    private static final float STUDENT_PRICE = 8.0f;
    private static final float GENERAL_PRICE = 11.0f;
    private static final float GROUP_PRICE = 6.0f;
    private static final float EXCEPTION_3D_PRICE = 3.0f;
    private static final float EXCEPTION_OVERLENGTH_PRICE = 1.50f;
    private static final float EXCEPTION_CHEAP_MOVIE_DAY_PRICE = -2.0f;
    private static final float EXCEPTION_WEEKENDS_PRICE = 1.50f;
    private static final float EXCEPTION_LOGE_PRICE = 2.0f;

    private static final Day CHEAP_DAY = Day.THU;

    private static final int CHILD_AGE_LIMIT = 13;
    private static final int SENIOR_AGE_MIN = 65;
    private static final int MIN_GROUP_RATE_SIZE = 20;
    private static final int MIN_OVERLENGTH_MINUTES = 120;

  private int runtime;
  private Day day;
  private boolean isParquet;
  private boolean is3D;
  private ArrayList<Customer> customers;

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
        this.runtime = runtime;
        this.day = day;
        this.isParquet = isParquet;
        this.is3D = is3D;
        this.customers = new ArrayList<Customer>();
    }

    /**
     * (2) Add a ticket to the customers' bill
     *
     * @param age           the age of the ticket buyer in years
     * @param isStudent     true if the ticket buyer is a student
     */
    public void addTicket(int age, boolean isStudent) {
        // set base rate
        Float baseRate = 0.0f;

        if (isChild(age)) {
            baseRate = CHILD_PRICE;
        } else if (isSenior(age)) {
            baseRate = SENIOR_PRICE;
        }
        else if (isStudent) {
            baseRate = STUDENT_PRICE;
        } else {
            baseRate = GENERAL_PRICE;
        }

        this.customers.add(new Customer(age, baseRate));
    }

    private boolean isChild(int age) {
        return age < CHILD_AGE_LIMIT;
    }

    private boolean isSenior(int age) {
        return age >= SENIOR_AGE_MIN;
    }

    private boolean isGroupRate(int size) {
        if (size >= MIN_GROUP_RATE_SIZE) {
            return true;
        }

        return false;
    }

    /**
     * (3) Calculate the total purchase price for the current customer(s)
     *
     * @return  total in dollars
     */
    public float finishPurchase() {
        // qualifies for group rate?
        boolean overrideUseGroupRate = isGroupRate(this.customers.size());

        float sum = 0.0f;

        for (int i = 0; i < this.customers.size(); i++) {
            Customer currentCustomer = this.customers.get(i);
            float baseRate = getPriceForCustomer(currentCustomer, overrideUseGroupRate);

            sum += baseRate;
        }

        return sum;
    }

    private float getPriceForCustomer(Customer currentCustomer, boolean overrideUseGroupRate) {
        float baseRate = 0.0f;

        if (overrideUseGroupRate && !isChild(currentCustomer.age)) {
            baseRate = GROUP_PRICE;
        } else {
            baseRate = currentCustomer.baseRate;
        }

        if (this.is3D) {
            baseRate += EXCEPTION_3D_PRICE;
        }

        if (this.runtime > MIN_OVERLENGTH_MINUTES) {
            baseRate += EXCEPTION_OVERLENGTH_PRICE;
        }

        if (!overrideUseGroupRate && this.day == CHEAP_DAY) {
            baseRate += EXCEPTION_CHEAP_MOVIE_DAY_PRICE;
        }

        if (isWeekend(this.day)) {
            baseRate += EXCEPTION_WEEKENDS_PRICE;
        }

        if (isLoge(this.isParquet)) {
            baseRate += EXCEPTION_LOGE_PRICE;
        }

        return baseRate;
    }

    private boolean isWeekend(Day d) {
        return d == Day.SAT || d == Day.SUN;
    }

    private boolean isLoge(boolean isGeneral) {
        return !isGeneral;
    }


}
