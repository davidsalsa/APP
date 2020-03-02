package huiswerk2020.Trees;

public class Node<T extends Comparable<T>>{
    T key;
    Node<T> left;
    Node<T> right;

    public Node(T item) {
        key = item;
        left = right = null;
    }


    public Node<T> findNodeRecursively(T value) {
        if (value.compareTo(key) < 0) {
            return left.findNodeRecursively(value);
        }
        if (value.compareTo(key) > 0) {
            return right.findNodeRecursively(value);
        }

        return this;
    }
}