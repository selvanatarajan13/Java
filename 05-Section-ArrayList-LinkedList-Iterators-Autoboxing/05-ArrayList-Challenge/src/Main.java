import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private  static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        /*
            Create a interactive console program, with a menu of options as shown here,

            0 - to shut down or kill the program
            1 - to add an item to the list
            2 - to remove any item in the list

            * The list will be grocery list and should be an ArrayList
            * you should use methods on the array list to add item, to remove item, to check if the
              item have already existed in the list and print a sorted list.
            * You should print the list, sort alphabetically, after each opeartion.
            * you shouldn't allow duplicate items in the list.
         */

        boolean flag = true;
        ArrayList<String> groceryItems = new ArrayList<>();

        while (flag) {
            printActions();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> addItems(groceryItems);
                case 2 -> removeItem(groceryItems);
                default -> flag = false;
            }

            groceryItems.sort(Comparator.naturalOrder());
            System.out.println(groceryItems);
        }
    }

    private static void removeItem(ArrayList<String> groceryItems) {
        System.out.print("remove items [separate by comma]: ");
        String[] values = scanner.nextLine().split(",");

        for (String value: values) {
            String trimValue = value.trim().toUpperCase();
            if (groceryItems.contains(trimValue)) {
                groceryItems.remove(trimValue);
                System.out.println("Item successfully removed..");
            } else {
                System.out.println("Item not present in the list..");
            }
        }
    }

    private static void addItems(ArrayList<String> groceryItems) {
        System.out.print("Add items [separate by comma]: ");
        String[] values = scanner.nextLine().split(",");

        // groceryItems.addAll(List.of(values));

        for (String value : values) {
            // trim the white spaces
            String trimValue = value.trim().toUpperCase();
            if (groceryItems.indexOf(trimValue) < 0) {
                groceryItems.add(trimValue);
                System.out.println("Item is successfully added..");
            } else {
                System.out.println("Item is already added in the list..");
            }
        }
    }

    private static void printActions() {
        String textBlock = """
                Available actions:
                
                0 - kill the program
                1 - add the items to list
                2 - remove the items from the list
                Enter a number which option you want go to do:""";

        System.out.print(textBlock + " ");
    }
}