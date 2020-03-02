package huiswerk2020.Trees;

import scala.Int;

public class BinarySearchTree<T extends Comparable<T>>  {
    private Node<T> root;

    private BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(Node<T> root){
        this.root = root;
    }

    private void insert(T key) {
        root = insertRec(root, key);
    }

    private Node<T> insertRec(Node<T> root, T key) {

        /* If the tree is empty, return a new node */
        if(root == null){
            root = new Node<>(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key.compareTo(root.key) < 0)
            root.left = insertRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = insertRec(root.right, key);


        /* return the (unchanged) node pointer */
        return root;
    }


    // only works with BST
    public Node findNode(T value){
        if(root == null){
            return null;
        }
        return root.findNodeRecursively(value);
    }

    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);

    }
}
