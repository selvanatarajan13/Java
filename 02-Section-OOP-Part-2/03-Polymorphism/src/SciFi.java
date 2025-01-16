public class SciFi extends Movie {

    public SciFi(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("..%s%n".repeat(4), "Innovative and groundbreaking",
                "Philosophical and psychologically complex", "Action-packed and thrilling",
                "Mind-bending and intellectually stimulating");
        System.out.println("-----------------------------------");
    }
}
