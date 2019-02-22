package huiswerk.lists;

public class HANStack<T> {

    public T top(HANLinkedList list){
        return (T) list.get(getSize(list));
    };

    public int getSize(HANLinkedList list){
        LinkedListNode<T> node =list.first;
        int count=1;

        while(node.getNext() != null){
            count++;
            node = node.getNext();
        }

        return count;
    };
}
