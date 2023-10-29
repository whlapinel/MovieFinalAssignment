
import java.util.Scanner;

public class Movie {
	private int rank;
  private String Title;
  private String Genre;
  private String Description;
  private String Director;
  private String Actors;
	private int Year;
	private int Duration; //rutime in minute
	private double Rating;
  private int Votes;
  private Double Revenue;
  private int Metascore;
  Movie(){
    this.rank = 0;
    this.Title = "Invalid_data";
    this.Genre = "";
    this.Description = "";
    this.Director = "";
    this.Actors = "";
    this.Year = 0;
    this.Duration = 0; //rutime in minute
    this.Rating = 0.0;
    this.Votes = 0;
    this.Revenue = 0.0;
    this.Metascore = 0;
  }
  Movie(int rank, String Title, String Genre, String Description, String Director, String Actors, int Year, int Duration, double Rating, int Votes, double Revenue, int Metascore){
    this.rank = rank;
    this.Title = Title;
    this.Genre = Genre;
    this.Description = Description;
    this.Director = Director;
    this.Actors = Actors;
    this.Year = Year;
    this.Duration = Duration; //rutime in minute
    this.Rating = Rating;
    this.Votes = Votes;
    this.Revenue = Revenue;
    this.Metascore = Metascore;
  }
  // DECLARE SETTERS

  // DECLARE GETTERS
  String getTitle(){
    return this.Title;
  }

///OVERIDE THE compareTo METHOD TO COMPARE by REVENUE


/* IMPLEMENT  printTitleRevnue METHOD WHICH  PRINTS THE TITLE 
OF THE MOVIE AND IT'S REVENUE*/


	

//Method to print the detail of a movie
	public void printMovieDetails() {
			System.out.println("TITLE: " + this.Title + "; GENRE: " + this.Genre + "; DESCRIPTION: " + this.Description + "; DIRECTOR: " + this.Director + "; ACTORS:" + this.Actors  + "; YEAR: " + this.Year  + "; DURATION: " + this.Duration + " minutes"  
					 + "; RATING: " + this.Rating + "; VOTES: " + this.Votes + "; REVENUE: $" + this.Revenue + " Million USD; METASCORE: " + this.Metascore+ "\n");
			System.out.println();
		
	}
}
