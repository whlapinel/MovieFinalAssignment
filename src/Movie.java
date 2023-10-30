public class Movie {
    private final int rank;
    private final String title;
    private final String genre;
    private final String description;
    private final String director;
    private final String actors;
    private final int year;
    private final int duration; //runtime in minute
    private final double rating;
    private final int votes;
    private final Double revenue;
    private final int metascore;

    Movie() {
        this.rank = 0;
        this.title = "Invalid_data";
        this.genre = "";
        this.description = "";
        this.director = "";
        this.actors = "";
        this.year = 0;
        this.duration = 0; //runtime in minute
        this.rating = 0.0;
        this.votes = 0;
        this.revenue = 0.0;
        this.metascore = 0;
    }

    Movie(int rank, String title, String genre, String description, String director, String actors, int year,
          int duration, double rating, int votes, double revenue, int metascore) {
        this.rank = rank;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.duration = duration; //runtime in minute
        this.rating = rating;
        this.votes = votes;
        this.revenue = revenue;
        this.metascore = metascore;
    }
    // DECLARE SETTERS

    // Not appropriate to declare setters when not used

    // DECLARE GETTERS

    // Only 2 attributes require getters.
    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return year;
    }

    ///OVERRIDE THE compareTo METHOD TO COMPARE by REVENUE
    public int compareTo(Movie otherMovie) {
        return otherMovie.revenue.compareTo(this.revenue);
    }

    /* IMPLEMENT  printTitleRevenue METHOD WHICH  PRINTS THE TITLE
    OF THE MOVIE AND ITS REVENUE*/
    public void printTitleRevenue() {
        if (!this.title.equals("Invalid_data")) {
            System.out.printf("TITLE: %s \nREVENUE: $%.2fM\n", this.title, this.revenue);
        }
    }

    // Method to print the details of a movie
    // not used
//    public void printMovieDetails() {
//        System.out.println("TITLE: " + this.title + ";\nGENRE: " + this.genre + ";\nDESCRIPTION: " + this.description +
//                ";\nDIRECTOR: " + this.director + ";\nACTORS:" + this.actors + ";\nYEAR: " + this.year +
//                ";\nDURATION: " + this.duration + " minutes"
//                + ";\nRATING: " + this.rating + ";\nVOTES: " + this.votes + ";\nREVENUE: $" + this.revenue +
//                " Million USD;\nMETASCORE: " + this.metascore + "\n");
//        System.out.println();
//    }


}
