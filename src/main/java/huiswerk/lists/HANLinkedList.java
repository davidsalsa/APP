package huiswerk.lists;

public class HANLinkedList<T> {

    private LinkedListNode<T> first = null;

    public void addFirst(LinkedListNode<T> node) {
        node.setNext(first);
        first = node;
    }

    public void removeFirst(){
        if(first.getNext()!=null)
            first = first.getNext();
        else first = null;
    }

    public void insert(int index, LinkedListNode<T> node){

    }

    public void delete (int index){

    }

    public void get(int index){

    }

    private void printList(LinkedListNode<T> node) {
        System.out.println(node.getValue());
        if(node.getNext()!=null) printList(node.getNext());
    }

    public void print(){
        printList(first);
    }


    public static void main(String[] args) {

        HANLinkedList<Integer> listInteger = new HANLinkedList<Integer>();
        listInteger.addFirst(new LinkedListNode<Integer>(1));
        listInteger.addFirst(new LinkedListNode<Integer>(2));
        listInteger.addFirst(new LinkedListNode<Integer>(3));
        listInteger.print();
        listInteger.removeFirst();
        System.out.println("After removing...");
        listInteger.print();
    }

}

class LinkedListNode<T> {
    private T value;
    private T index;
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