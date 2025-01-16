import java.util.HashMap;

public class HashProgram {

    static final int size = 20;
    static DataItem[] hashArray = new DataItem[size];

    // initiate the hashArray by,


    // subclass
    static class DataItem{
        int key;
        int value;

        public DataItem(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static int hashCode(int hashIndex) {
        return hashIndex % 10;
    }

    private static void insert(int key, int value) {
        int hashIndex;
        DataItem item = new DataItem(key, value);
        hashIndex = hashCode(key);

        while ((hashArray[hashIndex] != null) && (hashArray[hashIndex].key != -1)) {
            hashIndex = (hashIndex + 1) % size;
        }
        hashArray[hashIndex] = item;
    }

    private static void display() {
        for (int index=0; index < size; index++) {
            if (hashArray[index] != null) {
                System.out.println("Hash index " + index + " : " + "(" + hashArray[index].key + "," + hashArray[index].value + ")");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hash program..");
        for (int i=0; i<size; i++) {
            hashArray[i] = new DataItem(-1, -1);
        }

        insert(5, 15);
        insert(10, 66);
        insert(10, 78);
        insert(1, 45);
        insert(5,20);
        display();
    }
}
