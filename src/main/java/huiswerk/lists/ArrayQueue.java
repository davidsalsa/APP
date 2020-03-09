package huiswerk.lists;

import huiswerk.PO_algoritmen_her_2.ListNode;

public class ArrayQueue<T> {

    private ListNode<T> front;
    private ListNode<T> back;

    public void enqueue(T value){
        if(isEmpty()){
            front = back = new ListNode<>(value);
        } else {
            back = back.next = new ListNode<>(value);
        }
    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        T value = front.getValue();
        front = front.next;
        return value;
    }

    public T getFront(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("getFront(): queue empty");
        }
        return front.getValue();
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void makeEmpty(){
        front = null;
        back = null;
    }

}
