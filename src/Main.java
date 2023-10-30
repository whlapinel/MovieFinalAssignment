import java.io.*;
import java.util.*;

/*
Due Nov 12 by 11:59pm Points 100 Submitting a text entry box, a website url, or a file upload
This assignment is going to allow you to demonstrate your understanding of everything you have learned in the course.

Please note that you have two weeks to complete this assignment.

We have provided starter code  for the assignment. View starter code here. Links to an external site.
The starter code has an incomplete Movie Class, the IMDB Movie data set  and a Main.

In the Movie Class there are comments that are in uppercase letters. You should implement the instructions of those
comments. You will earn 30 points for the following  implementations:

Implementing all appropriate Getter Methods (5 points)
Implementing all appropriate Setter Methods (5 points)
Implementing the "printTitleRevenue" method. This method should print the title of the Movie and it's revenue. (5points)
Implementing the override of the compareTo Method in order to compare Movies by revenue (15 points)
Refer to this resourceLinks to an external site. in order to understand how the compareTo method  and Java Collections
sort method works .
You will earn 70-75 points for the following implementations in Main:

Implement a HashMap call movieYearMap whose key is the movie Year, an Integer, and whose Value is a List of all Movies in that year (5 points)
Loop over all the Movies in the data file. Add each movie to  movieYearMap (20 points)
Create an ArrayList of all the years in movieYearMap and sort them in ascending order (15 points).
For each key (year) in movieYearMap use the Java collections sort method to sort the associated Movie list in descending order by revenue. The highest revenue grossing movie for the year should be at the start of the list. (15 points)
Starting at the lowest year in  movieYearMap, use the "printTitleRevenue"  method in Movie class to sprint out the highest revenue grossing movie for the year and the lowest grossing movie (20 points). 5 Bonus points for printing the lowest earning movie without iterating over the entire ArrayList (+5 points).
When finished submit your Repl.it link to the assignment

Assignment Resources:HashMap in Java with Examples

HashMap in Java with Examples Links to an external site.(After reviewing examples the "Methods in HashMap" section may be useful)
Using Java Comparator and Java Collections SortLinks to an external site.
HashMap with multiple values under the same key Links to an external site.(Look at "Examples  1. Map with list as the value")
Sorting an ArrayList in descending orderLinks to an external site.
Traversing and printing elements in a HashMapLinks to an external site.
 */
class Main {
    public static void main(String[] args) {
        String data;
        try {
            File myFile = new File("IMDB-Movie-Data.csv");
            Scanner myReader = new Scanner(myFile);
            data = myReader.nextLine();// Read and ignore header line in file
            ArrayList<Movie> movieList = new ArrayList<>();
            /*
             Step 1 Implement a HashMap call movieYearMap whose key is the movie Year, an Integer, and whose Value is a
             List of all Movies in that year (5 points)
            */
            HashMap<Integer, ArrayList<Movie>> movieYearMap = new HashMap<>();
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                Movie temp_movie = parseMovie(data);
                //If line of data created a valid Movie object
                if (!temp_movie.getTitle().equals("Invalid_data")) {
                    //Print Movie Object details
//                    temp_movie.printMovieDetails();
                    movieList.add(temp_movie);
                }
            }
            movieList.sort(Movie::compareTo);
            // Step 2 Loop over all the Movies in the data file. Add each movie to  movieYearMap
            // (20 points)
            for (Movie movie : movieList) {
                ArrayList<Movie> modifiedArray = movieYearMap.get(movie.getYear());
                if (modifiedArray != null) {
                    modifiedArray.add(movie);
                } else {
                    modifiedArray = new ArrayList<>(List.of(movie));
                }
                movieYearMap.put(movie.getYear(), modifiedArray);
            }
            // Step 3 Create an ArrayList of all the years in movieYearMap and sort them in ascending order (15 points).
            ArrayList<Integer> movieYearArray = new ArrayList<>(movieYearMap.keySet());
            movieYearArray.sort(Integer::compareTo);
            // Step 4 For each key (year) in movieYearMap use the Java collections sort method to sort the associated
            // Movie list in descending order by revenue. The highest revenue grossing movie for the year should be at
            // the start of the list. (15 points)
            for (Integer year : movieYearArray) {
                movieYearMap.get(year).sort(Movie::compareTo);
                // Step 5 Starting at the lowest year in  movieYearMap, use the "printTitleRevenue"  method in Movie class
                // to sprint out the highest revenue grossing movie for the year and the lowest grossing movie (20 points).
                // 5 Bonus points for printing the lowest earning movie without iterating over the entire ArrayList
                // (+5 points).
                System.out.println("Year: " + year);
                System.out.println("Highest Grossing Movie: ");
                movieYearMap.get(year).get(0).printTitleRevenue(); //should give me an array list.
                System.out.println();
                System.out.println("Lowest Grossing Movie: ");
                movieYearMap.get(year).get(movieYearMap.get(year).toArray().length - 1).printTitleRevenue();
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//--------------------Do not edit below here----------------------------------

    /*Method that tokenizes string and returns a Movie object if line is valid, returns Movie with title =
    "Invalid_data" if exception is throw because line is missing data.*/

    public static Movie parseMovie(String lineData) {
        //Declare variables to store movie data
        int temp_rank;
        String temp_title;
        String temp_genre;
        String temp_description;
        String temp_director;
        String temp_actors;
        int temp_year;
        int temp_duration; //runtime in minute
        double temp_rating;
        int temp_votes;
        double temp_revenue;
        int temp_metascore;
        // Split movie line
        String[] lineTokens = lineData.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);//Regex to split line
        try {
            temp_rank = Integer.parseInt(lineTokens[0]);
            temp_title = lineTokens[1];
            temp_genre = lineTokens[2];
            temp_description = lineTokens[3];
            temp_director = lineTokens[4];
            temp_actors = lineTokens[5];
            temp_year = Integer.parseInt(lineTokens[6]);
            temp_duration = Integer.parseInt(lineTokens[7]); //runtime in minute
            temp_rating = Double.parseDouble(lineTokens[8]);
            temp_votes = Integer.parseInt(lineTokens[9]);
            temp_revenue = Double.parseDouble(lineTokens[10]);
            temp_metascore = Integer.parseInt(lineTokens[11]);
        } catch (Exception e)//Line of data is missing information or is invalid
        {
            //Create default movie with "Invalid_data" title
            return new Movie();
        }
        //Line of data had all information
        //Create Movie Object with data
        return new Movie(temp_rank, temp_title, temp_genre, temp_description, temp_director, temp_actors, temp_year,
                temp_duration, temp_rating, temp_votes, temp_revenue, temp_metascore);
    }
}