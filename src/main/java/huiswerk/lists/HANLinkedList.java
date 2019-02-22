package huiswerk.lists;

public class HANLinkedList<T> {

    public LinkedListNode<T> first = null;

    public void addFirst(LinkedListNode<T> node) {
        node.setNext(first);
        first = node;
    }

    public void removeFirst() {
        if (first.getNext() != null)
            first = first.getNext();
        else first = null;
    }

    public void insert(int index, LinkedListNode<T> node) {
        LinkedListNode<T> temp = node;
        LinkedListNode<T> currentNode = first;

        if (index == 0) {
            temp.setNext(first);
            this.first = temp;
        } else {
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            temp.setNext(currentNode.getNext());
            currentNode.setNext(temp);
        }
    }

    public void delete(int index) {
        if (first == null)
            return;

        LinkedListNode temp = first;

        if (index == 0) {
            first = temp.getNext();   // Change head
            return;
        }

        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.getNext();

        if (temp == null || temp.getNext() == null)
            return;

        LinkedListNode next = temp.getNext().getNext();

        temp.setNext(next);
    }

    public T get(int index) {

        LinkedListNode<T> current = first;
        int count = 0;
        T value = current.getValue();
        while (current != null) {
            if (count == index)
                value = current.getValue();
            count++;
            current = current.getNext();
        }
        return value;
    }

    private void printList(LinkedListNode<T> node) {
        System.out.println(node.getValue());
        if (node.getNext() != null) printList(node.getNext());
    }

    public void print() {
        printList(first);
    }


    public static void main(String[] args) {
        HANLinkedList list = new HANLinkedList();
        HANStack hanStack = new HANStack(list);

        list.addFirst(new LinkedListNode<Integer>(1));
        list.addFirst(new LinkedListNode<Integer>(3));
        list.addFirst(new LinkedListNode<Integer>(4));
        list.addFirst(new LinkedListNode<Integer>(6));
        list.insert(1, new LinkedListNode<Integer>(5));
        list.print();
        list.removeFirst();
        System.out.println("After removing...");
        list.print();
        System.out.println("get...");
        System.out.println(list.get(2));
        list.insert(3, new LinkedListNode<String>("Hello!"));
        System.out.println("After inserting...");
        list.print();
        list.delete(1);
        System.out.println("After delete...");
        list.print();
        System.out.println("count...");
        System.out.println(hanStack.getSize());
        System.out.println("top...");
        System.out.println(hanStack.top());
        System.out.println(hanStack.pop());
        System.out.println(hanStack.push(69));

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

class HANStack<T> {

    private HANLinkedList list;

    public HANStack(HANLinkedList list) {
        this.list = list;
    }

    public T push(T value) {
        list.addFirst(new LinkedListNode(value));
        T pushedItem = (T) list.get(getSize());
        return pushedItem;
    }

    public T pop() {
        if(list.first == null)
            return null;

        T removedItem = (T) list.get(getSize());
        list.removeFirst();
        return removedItem;
    }

    public T top() {
        return (T) list.get(getSize());
    }

    public int getSize() {
        LinkedListNode<T> node = list.first;
        int count = 1;

        while (node.getNext() != null) {
            count++;
            node = node.getNext();
        }

        return count;
    }
}