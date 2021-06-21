package de.saxsys.dojo.ticketkata;

public class Movie {

    private final String title;
    private final int runtime;

    public Movie(String title, int runtime) {
        this.title = title;
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public int getRuntime() {
        return runtime;
    }

    public boolean isOverLength() {
        return runtime > Config.OVER_LENGTH_MOVIE_THRESHOLD;
    }

    public boolean is3D() {
        return title.endsWith("in 3D");
    }

}
