class Sample {
    int id;
    int mark;

    Sample(int id, int mark) {
        this.id = id;
        this.mark = mark;
    }

    void setId(int id) {
        this.id = id;
    }

    void setMark(int mark) {
        this.mark = mark;
    }

}

public class JavaConstructor {
    public static void main(String[] args) {
        Sample obj = new Sample(4, 98);
        System.err.println(obj.id);
        System.err.println(obj.mark);
    }
}