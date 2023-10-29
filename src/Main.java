import java.io.*;
import java.util.Scanner; // Import the Scanner class to read text 
class Main {
  public static void main(String[] args) {
  String data;
   try {
      File myObj = new File("IMDB-Movie-Data.csv");
      Scanner myReader = new Scanner(myObj);
      data = myReader.nextLine();// Read and ingnore header line in file
              
     // while (myReader.hasNextLine()) {
        data = myReader.nextLine();
        Movie temp_movie = new Movie();
        temp_movie = parseMovie(data);
        //If line of data created a valid Movie object
        if(temp_movie.getTitle() != "Invalid_data"){
          //Print Movie Obkect details
          temp_movie.printMovieDetails();
        }
           
     //}    


      
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }


//--------------------Do not edit below here----------------------------------

  /*Method that tokenizes string and returns a Movie object if line is valid, returns Movie with title = "Invalid_data" if exception is throw because line is missing data.*/

  public static Movie parseMovie(String lineData){
      //Declare variables to store movie data
      int temp_rank;
      String temp_title;
      String temp_genre;
      String temp_description;
      String temp_director;
      String temp_actors;
      int temp_year;
      int temp_duration; //rutime in minute
      double temp_rating;
      int temp_votes;
      Double temp_revenue;
      int temp_metascore;
      // Split movie line 
      String lineTokens[] = lineData.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);//Regex to split line
      try{
        temp_rank = Integer.parseInt(lineTokens[0]);
        temp_title = lineTokens[1];
        temp_genre = lineTokens[2];
        temp_description = lineTokens[3];
        temp_director = lineTokens[4];
        temp_actors = lineTokens[5];
        temp_year = Integer.parseInt(lineTokens[6]);
        temp_duration = Integer.parseInt(lineTokens[7]); //rutime in minute
        temp_rating = Double.parseDouble(lineTokens[8]);
        temp_votes = Integer.parseInt(lineTokens[9]);
        temp_revenue = Double.parseDouble(lineTokens[10]);
        temp_metascore = Integer.parseInt(lineTokens[11]);
      }catch(Exception e)//Line of data is missing information or is invalid
      { 
        //Create default movie with "Invalid_data" title
        Movie invalidMovieData = new Movie(); 
        return invalidMovieData;
      }
      //Line of data had all information
      //Create Movie Object with data
      Movie  myMovie = new Movie(temp_rank, temp_title, temp_genre,temp_description, temp_director, temp_actors, temp_year, temp_duration, temp_rating, temp_votes, temp_revenue, temp_metascore);
      return myMovie;
    }
}