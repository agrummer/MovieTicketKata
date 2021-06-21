package de.saxsys.dojo.ticketkata;

import java.util.function.Function;

public class TicketPriceAdjustment {

    private final float amount;
    private final Function<Parameters, Boolean> shouldApply;

    public TicketPriceAdjustment(float amount, Function<Parameters, Boolean> shouldApply) {
        this.amount = amount;
        this.shouldApply = shouldApply;
    }

    public boolean appliesTo(Movie movie, Day day, boolean isParquet, boolean isGroup) {
        return shouldApply.apply(new Parameters(movie, day, isParquet, isGroup));
    }

    public float getAmount() {
        return amount;
    }

    static class Parameters {
        private final Movie movie;
        private final Day day;
        private final boolean isParquet;
        private final boolean isGroup;

        public Parameters(Movie movie, Day day, boolean isParquet, boolean isGroup) {
            this.movie = movie;
            this.day = day;
            this.isParquet = isParquet;
            this.isGroup = isGroup;
        }

        public Movie getMovie() {
            return movie;
        }

        public Day getDay() {
            return day;
        }

        public boolean isParquet() {
            return isParquet;
        }

        public boolean isGroup() {
            return isGroup;
        }
    }

}
