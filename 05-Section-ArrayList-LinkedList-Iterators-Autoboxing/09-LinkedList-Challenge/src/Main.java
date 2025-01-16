import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        LinkedList<Place> placesToVisit = new LinkedList<>();

        Place tiruchendur = new Place("Tiruchendur", 18);
        addPlace(placesToVisit, tiruchendur);
        addPlace(placesToVisit, new Place("Tirunelveli", 40));
        addPlace(placesToVisit, new Place("Sathankulam", 16));
        addPlace(placesToVisit, new Place("Kayalpatnam", 20));
        addPlace(placesToVisit, new Place("Kulasai", 8));
        addPlace(placesToVisit, new Place("Kulasai", 8));
        placesToVisit.addFirst( new Place("Udangudi", 0));

        System.out.println(placesToVisit);

        printItinerary(placesToVisit);
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        // neglect the duplicate object

        int indexMatched = 0;
        for (Place p: list) {
            if (place.name().equalsIgnoreCase(p.name()) != true && place.distance() < p.distance()) {
                list.add(indexMatched, place);
                return;
            } else if (place.distance() < p.distance()) {
                list.add(indexMatched, place);
                return;
            }

            indexMatched++;
        }

        list.add(place);
    }

    private static void printItinerary(LinkedList<Place> list) {

        System.out.println("The trip start at: " + list.getFirst());
        System.out.println("The trip end at: " + list.getLast());
        Place previousTown = list.getFirst();
        ListIterator<Place> iterator = list.listIterator(1);
        while (iterator.hasNext()) {
            Place town = iterator.next();
            System.out.println("-->From: " + previousTown.name() + " to: " + town);
            previousTown = town;
        }
    }
}