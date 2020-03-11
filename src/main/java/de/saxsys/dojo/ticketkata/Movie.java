package de.saxsys.dojo.ticketkata;

public class Movie {

    private int runtime;
    private boolean is3D;

    public Movie(int runtime, boolean is3D) {
        this.runtime = runtime;
        this.is3D = is3D;
    }

    public boolean isOverLength() {
        return runtime > CashRegisterConfig.OVER_LENGTH_MOVIE_THRESHOLD;
    }

    public boolean is3D() {
        return is3D;
    }

}
