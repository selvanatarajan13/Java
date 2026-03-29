public abstract class AbstractAnimal implements Animal {

    @Override
    public void sound() {
        String sound = getSound();
        System.out.println("Animal sound: " + sound);
    }

    protected abstract String getSound();
}
