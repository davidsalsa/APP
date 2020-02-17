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

        LinkedListNode<T> temp = first;

        if (index == 0) {
            first = temp.getNext();   // Change head
            return;
        }

        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.getNext();

        if (temp == null || temp.getNext() == null)
            return;

        LinkedListNode<T> next = temp.getNext().getNext();

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
        HANStack<Integer> hanStack = new HANStack<>();

        hanStack.push(1);
        hanStack.push(3);
        hanStack.push(4);
        hanStack.push(6);
        hanStack.push(5);
        hanStack.list.print();
        hanStack.pop();
        System.out.println("After removing...");
        hanStack.list.print();
        System.out.println("get...");
        System.out.println("After inserting...");
        hanStack.list.print();
        hanStack.pop();
        System.out.println("After delete...");
        hanStack.list.print();
        System.out.println("count...");
        System.out.println(hanStack.getSize());
        System.out.println("top...");
        System.out.println(hanStack.top());
        System.out.println(hanStack.pop());
        System.out.println(hanStack.push(69));

    }

}

class HANStack<T> {

    public HANLinkedList<T> list = new HANLinkedList<T>();

    public HANStack() {
    }

    public T push(T value) {
        list.addFirst(new LinkedListNode<>(value));
        return list.get(getSize());
    }

    public T pop() {
        T removedItem;

        if(list.first == null) {
            removedItem = null;
        } else {
            removedItem = list.get(getSize());
        }

        list.removeFirst();
        return removedItem;
    }

    public T top() {
        if(list.first == null){
            return null;
        }
        return list.get(getSize());
    }

    public int getSize() {
        LinkedListNode<T> node = list.first;

        if(node == null){
            return 0;
        }

        int count = 1;

        while (node.getNext() != null) {
            count++;
            node = node.getNext();
        }

        return count;
    }
}