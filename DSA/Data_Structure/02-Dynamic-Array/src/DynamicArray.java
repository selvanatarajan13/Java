public class DynamicArray {

    private int array[];
    private int size;
    private int count;

    public DynamicArray() {
        this.array = new int[5];
        this.size = 0;
        this.count = 0;
    }

    public void insert(int value) {
        if (size == array.length) {
            doubleArraySize();
        }
        array[size] = value;
        size++;
        count++;
    }

    public void addElementAt(int index, int value) {
        if (size == array.length) {
            doubleArraySize();
        }

        for (int i = count-1; i>= index; i--) {
            array[i+1] = array[i];
        }

        array[index] = value;
    }

    private void doubleArraySize() {

        int[] tempArray = new int[array.length * 2];
        for (int i=0; i<array.length; i++) {
            tempArray[i] = array[i];
        }

        array = tempArray;
    }

    public void printArray() {
        for (int number : array) {
            System.out.print(number + " ");
        }
    }

    public void getSizeOfArray() {
        System.out.println("\n"+array.length);
    }
}
