package huiswerk2020.Trees;

import scala.Int;

public class BinarySearchTree<T extends Comparable<T>>  {
    private Node<T> root;

    private BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(T rootValue){
        this.root = new Node<>(rootValue);
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

    private void remove(T key)
    {
        root = removeRec(root, key);
    }

    private Node<T> removeRec(Node<T> root, T key){
        if(root == null){
            return null;
        }
        if(key.compareTo(root.key) < 0){
            root.left = removeRec(root.left, key);
        }else if(key.compareTo(root.key) > 0){
            root.right = removeRec(root.right, key);
        }else{
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right == null){
                root = root.left;
            }else if(root.left == null){
                root = root.right;
            }else{
                root.key = findMin(root.right).key;
                root.right = removeRec(root.right, root.key);
            }
        }
        return root;
    }


    // only works with BST
    public Node findNode(T value){
        if(root == null){
            return null;
        }
        return root.findNodeRecursively(value);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(" " + node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(" " + node.key);
        }
    }

    Node<T> findMax(Node<T> root) {
        if (root != null) {
            if (root.right != null) {
                root = findMax(root.right);
            }
        }
        return root;
    }

    Node<T> findMin(Node<T> root) {
        if (root != null) {
            if (root.left != null) {
                root = findMin(root.left);
            }
        }
        return root;
    }

    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);


        tree.inOrder(tree.root);

        System.out.println(" ");

        tree.remove(4);
        tree.remove(5);

        tree.inOrder(tree.root);
        System.out.println("minimum value: " + tree.findMin(tree.root).key);
        System.out.println("maximum value: " + tree.findMax(tree.root).key);
    }
}
