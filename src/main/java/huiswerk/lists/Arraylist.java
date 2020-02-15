package huiswerk.lists;

import java.util.Arrays;

public class Arraylist <T> {

    private int index = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;


    public Arraylist(){

        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T value) {
        if (index == elements.length) {
            verdubbeling();
        }
        elements[index++] = value;
    }

    private void verdubbeling() {
        int newSize = elements.length * 2 + 1;
        elements = Arrays.copyOf(elements, newSize);
    }

    public Object getValue(int index){
        return elements[index];
    }

    public void setValue(int index, T value){
        elements[index] = value;
    }

    public static void main(String[] args) {
        Arraylist<Integer> list = new Arraylist<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for(int i=0; i<list.index; i++) {
            System.out.println(list.getValue(i));
        }

        list.setValue(1, 999);

        for(int i=0; i<list.index; i++) {
            System.out.println(list.getValue(i));
        }
    }
}

