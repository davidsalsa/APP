package huiswerk.PO_algoritmen_her_2;

public class DoublyLinkedList<T> {
    private ListNode<T> head = null;
    private ListNode<T> tail = null;

    private void addFirst(T value){
        ListNode<T> node = new ListNode<>(value);

        if (head == null) {
            node.next = null;
            node.prev = null;
            head = node;
            tail = node;

        } else {
            head.prev = node;
            node.next = head;
            node.prev = null;
            head = node;
        }
    }

    private void addLast(T value) {
        ListNode<T> node = new ListNode<>(value);

        if (tail == null) {
            node.next = null;
            node.prev = null;
            head = node;
            tail = node;

        } else {
            tail.prev = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }

    public void insert(int index, T value) {
        ListNode<T> temp = new ListNode<>(value);
        ListNode<T> currentNode = head;

        if (index == 0) {
            temp.setNext(head);
            this.head = temp;
        } else {
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            temp.setNext(currentNode.getNext());
            temp.setPrev(currentNode.getPrev());
            currentNode.setNext(temp);
        }
    }

    public void delete(int index) {
        if (head == null)
            return;

        ListNode<T> temp = head;

        if (index == 0) {
            head = temp.getNext();   // Change head
            return;
        }

        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.getNext();

        if (temp == null || temp.getNext() == null)
            return;

        ListNode<T> next = temp.getNext().getNext();

        temp.setNext(next);
    }

    private T get(int index) {

        ListNode<T> current = head;
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

    @Override
    public String toString() {
        return toStringRecursive(head);
    }

    private String toStringRecursive(ListNode<T> ln){
        if(ln == null)
        {
            return "";
        }
        else
        {
            return  ln.getValue() + " " + toStringRecursive(ln.next);
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Object> list = new DoublyLinkedList<>();

        list.addFirst(new ListNode<>(1));
        list.addLast(new ListNode<>(3));
        list.addFirst(new ListNode<>(4));
        list.addLast(new ListNode<>(6));

        System.out.print(list.toString());


    }
}