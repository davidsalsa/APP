package huiswerk.PO_algoritmen_her_2;

public class ListNode<T> {
    private T value;
    public ListNode<T> next;
    public ListNode<T> prev;

    public ListNode(T value) {
        this.value = value;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }


    public ListNode<T> getNext() {
        return next;
    }
    public ListNode<T> getPrev() { return prev; }
    public T getValue() { return value; }

    @Override
    public String toString() {
        return value.toString();
    }
}
