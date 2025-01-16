public class Comedy extends Movie {

    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("..%s%n".repeat(2),
                "Fast-peaced and entertaining", "Cleaver writing and physical comedy");
        System.out.println("-----------------------------------");
    }
}
