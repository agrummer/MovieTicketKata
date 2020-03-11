package de.saxsys.dojo.ticketkata;

public class CashRegisterConfig {

    // Base Admission Rates
    static final float DEFAULT_BASE_RATE = 11.00f;
    static final float STUDENT_BASE_RATE = 8.00f;
    static final float SENIOR_BASE_RATE = 6.00f;
    static final int SENIOR_MIN_AGE = 65;
    static final float CHILD_BASE_RATE = 5.50f;
    static final int CHILD_MAX_AGE = 12;
    static final float GROUP_BASE_RATE = 6.00f;
    static final int MIN_GROUP_SIZE = 20;

    // Premiums
    static final float THREE_DIMENSIONAL_MOVIE_PREMIUM = 3.00f;
    static final float OVER_LENGTH_MOVIE_PREMIUM = 1.50f;
    static final int OVER_LENGTH_MOVIE_THRESHOLD = 120;
    static final float WEEKEND_PREMIUM = 1.50f;
    static final float LOGE_SEATING_PREMIUM = 2.00f;

    // Discounts
    static final Day MOVIE_DAY = Day.THU;
    static final float MOVIE_DAY_DISCOUNT = 2.00f;

}
