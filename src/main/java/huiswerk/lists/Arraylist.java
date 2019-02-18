package huiswerk.lists;

import java.util.Arrays;

public class Arraylist {

    private int index = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];


    public Arraylist(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(int value) {
        if (index == elements.length) {
            verdubbeling();
        }
        elements[index++] = value;
    }

    private void verdubbeling() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public int getValue(int index){
        return (int) elements[index];
    }

    public void setValue(int index, int value){
        elements[index] = value;
    }
}

