package huiswerk2020.Trees;

public class Node<T extends Comparable<T>>{
    T key;
    Node<T> left;
    Node<T> right;

    public Node(T item) {
        key = item;
        left = right = null;
    }


    public void setLeft(Node<T> node){
        left = node;
    }

    public void setRight(Node<T> node){
        right = node;
    }

    public Node<T> findNodeRecursively(T value) {
        if(value.compareTo(key) == 0){
            return this;
        }

        if (value.compareTo(key) < 0 && left != null) {
            return left.findNodeRecursively(value);
        }
        if (value.compareTo(key) > 0 && right != null) {
            return right.findNodeRecursively(value);
        }
        throw new IndexOutOfBoundsException("Value not in tree!");
    }
}