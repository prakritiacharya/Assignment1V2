package ca.georgiancollege.movie_app;

public class Movie {
    private String title;
    private String year;
    private String type;
    private String poster;
    private String director;
    private String rating;
    private String plot;

    // Constructor
    public Movie(String title, String year, String type, String poster, String director, String rating, String plot) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.poster = poster;
        this.director = director;
        this.rating = rating;
        this.plot = plot;
    }

    // Getters
    public String getTitle() { return title; }
    public String getYear() { return year; }
    public String getType() { return type; }
    public String getPoster() { return poster; }
    public String getDirector() { return director; }
    public String getRating() { return rating; }
    public String getPlot() { return plot; }
}
