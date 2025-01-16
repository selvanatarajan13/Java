import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // Movie theMovie = Movie.getMovieWithType("science-fiction", "The Moon Fall");
        // theMovie.watchMovie();

        // let's create the interactive program

        Scanner c = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Enter the type of movie (Adventure or Comedy or Sci-Fi) else Q- quite : "
            );
            String movieType = c.nextLine();
            if (movieType.toUpperCase().charAt(0) == 'Q') {
                break;
            }

            System.out.println("Enter the movie title : ");
            String title = c.nextLine();

            Movie theMovie = Movie.getMovieWithType(movieType, title);
            theMovie.watchMovie();
        }

    }
}