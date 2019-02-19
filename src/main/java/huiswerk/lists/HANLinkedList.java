package huiswerk.lists;

import sun.awt.image.ImageWatched;

public class HANLinkedList<T> {

    private LinkedListNode<Integer> first = null;

    public void addFirst(LinkedListNode<Integer> node) {
        node.setNext(first);
        first = node;
    }

    public void removeFirst(){
        if(first.getNext()!=null)
            first = first.getNext();
        else first = null;
    }

    public void insert(int index, LinkedListNode<T> node){
        LinkedListNode<T> previousNode;
        LinkedListNode<T> currentNode;
    }

    public void delete (int index){

    }

    public int get(int index){

        LinkedListNode<Integer> current = first;
        int count=0;
        int value=0;
        while (current != null)
        {
            if (count == index)
                value = current.getValue();
            count++;
            current = current.getNext();
        }
        return value;
    }

    private void printList(LinkedListNode<Integer> node) {
        System.out.println(node.getValue());
        if(node.getNext()!=null) printList(node.getNext());
    }

    public void print(){
        printList(first);
    }


    public static void main(String[] args) {

        HANLinkedList listInteger = new HANLinkedList();
        listInteger.addFirst(new LinkedListNode<Integer>(1));
        listInteger.addFirst(new LinkedListNode<Integer>(99));
        listInteger.addFirst(new LinkedListNode<Integer>(3));
        listInteger.addFirst(new LinkedListNode<Integer>(4));
        listInteger.addFirst(new LinkedListNode<Integer>(6));
        listInteger.insert(1, new LinkedListNode<Integer>(5));
        listInteger.print();
        listInteger.removeFirst();
        System.out.println("After removing...");
        listInteger.print();
        System.out.println("get...");
        System.out.println(listInteger.get(2));
    }

}

class LinkedListNode<T> {
    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode(T value) {
        this.value = value;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }
}