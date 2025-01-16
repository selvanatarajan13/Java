public class Adventure extends Movie {

    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        // here, I am going to use printF method
        System.out.printf("..%s%n".repeat(3), "Pleasant Scenes", "Scary Music", "Adventure Musics");
        System.out.println("-----------------------------------");
    }
}
