import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*
            This is the linkedlist challenge.

            Create a list of places, ordered by distance from the starting point.
            you must use a listIterator to move both forward and backward navigation through
            this ordered iternary places.

            Note: It can't allows to present the duplicate values in the lnikedlist.

            In addition, we will create an interactive program with the following menu item
            options:
                Avaliable action:

                (F)orward
                (B)ackward
                (L)ist of places ordered
                (M)enu
                (Q)uit
         */

        LinkedList<Place> placeToVisit = new LinkedList<>();

        addPlace(placeToVisit, new Place("Tiruchendur", 15));
        addPlace(placeToVisit, new Place("Sathankulam", 16));
        addPlace(placeToVisit, new Place("Kulasai", 6));
        addPlace(placeToVisit, new Place("Tirunelveli", 40));
        addPlace(placeToVisit, new Place("Kayalpatnam", 20));
        addPlace(placeToVisit, new Place("Kayalpatnam", 20));
        placeToVisit.addFirst(new Place("Udangudi", 0));
        System.out.println(placeToVisit);

        printMenu();
        boolean flag = true;
        while (flag) {
            switch (scanner.nextLine().substring(0,1).toUpperCase()) {
                case "L" -> travsePlaces(placeToVisit);
                case "M" -> printMenu();
                default -> flag = false;
            }
        }

    }

    private static void travsePlaces(LinkedList<Place> places) {

        Place previousTown = places.getFirst();
        ListIterator<Place> iterator = places.listIterator(1);
        System.out.println("Originating from: " + previousTown);

        while (iterator.hasNext()) {
            Place town = iterator.next();
            System.out.println("-->From: " + previousTown + " to: " + town);
            previousTown = town;
        }
    }

    private static void addPlace(LinkedList<Place> listOfPlace, Place place) {

        int matchedIndex = 0;
        for (Place p: listOfPlace) {
            if (p.name().equalsIgnoreCase(place.name())) {
                System.out.println("Found duplicate: "+ place.name());
                return;
            }

            if (place.distance() < p.distance()) {
                listOfPlace.add(matchedIndex, place);
                System.out.println("1Successfully added the place: " + place.name());
                return;
            }

            matchedIndex++;
        }

        if (listOfPlace.isEmpty()) {
            listOfPlace.add(place);
            System.out.println("2Successfully added the place : " + place.name());
        } else {
            listOfPlace.add(place);
        }
    }

    private static void printMenu() {
        String textBlock = """
                Avaliable action:
                                
                (A)dd place
                (F)orward
                (B)ackward
                (L)ist of places ordered
                (M)enu
                (Q)uit
                Enter a text which option you want to do:""";

        System.out.print(textBlock + " ");
    }
}