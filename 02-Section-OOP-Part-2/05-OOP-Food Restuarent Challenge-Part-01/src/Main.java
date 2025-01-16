public class Main {
    public static void main(String[] args) {
//        Item item = new Item(
//                "Drink", "Bovonto", 40
//        );
//        item.setSize("large");
//        item.printItem();
//
//        Item item1 = new Item(
//                "Snacks", "Pottato Salad", 80
//        );
//        item1.printItem();

        OrderCard orderCard = new OrderCard(
                "Bovonto", "Onion Rings"
        );
        orderCard.setDrinkSize("large");
        orderCard.printListItems();
    }
}