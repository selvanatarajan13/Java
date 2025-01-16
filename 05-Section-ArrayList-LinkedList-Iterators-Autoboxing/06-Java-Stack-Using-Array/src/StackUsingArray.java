public class StackUsingArray {

    static final int size = 5;
    int top = -1;

    int[] array = new int[size];

    public void add(int val) {
        array[++top] = val;
        System.out.println("Element added sucessfully");
    }

    public int pop() {
        System.out.println("Last element deleted sucessfully" + top);
        return array[top--];
    }

    public void view() {
        if (top == -1) {
            System.out.println("Array is empty..");
        } else {
            System.out.print("Head->");
            for (int i=0; i<top-1; i++) {
                System.out.print(array[i] + "->");
            }
            System.out.print("Null");
        }
    }
}
