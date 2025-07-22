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
    public Movie(String title, String year, String imdbID, String type, String poster) {
        this.Title = title;
        this.Year = year;
        this.imdbID = imdbID;
        this.Type = type;
        this.Poster = poster;
    }

    // Getters
    public String getTitle() { return Title; }
    public String getYear() { return Year; }
    public String getImdbID() { return imdbID; }
    public String getType() { return Type; }
    public String getPoster() { return Poster; }
}
