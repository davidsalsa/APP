package huiswerk.oefentoets;

import huiswerk.sort.generics.QuickSortGeneric;

public class BinarySearchTreeGeneric<T extends Comparable<? super T>>{
   static Node root;

    BinarySearchTreeGeneric() {
        root = null;
    }

    <T extends Comparable<T>> void insert(T key) {
        root = insertRec(root, key);
    }

    static <T extends Comparable<T>> Node insertRec(Node root, T key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key.compareTo((T) root.key) < 0)
            root.left = insertRec(root.left, key);
        else if (key.compareTo((T) root.key) > 0)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(" " + node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(" " + node.key);
        }
    }

    Node find(Node root, T value) {
        if (root != null) {
            if (root.key.compareTo(value) > 0) {
                root = find(root.left, value);
            } else if (root.key.compareTo(value) < 0) {
                root = find(root.right, value);
            }

        } else throw new Error("Given value does not exist in this tree.");
        return root;
    }

    Comparable findMaxNode (Node root) {
        if (root != null) {
            if (root.right != null) {
                root.key = findMax(root.right);
            }
        }
        return root.key;
    }
    Comparable findMax(Node root) {
        if (root != null) {
            if (root.right != null) {
                root.key = findMax(root.right);
            }
        }
        return root.key;
    }

    Comparable findMin(Node root) {
        if (root != null) {
            if (root.left != null) {
                root.key = findMin(root.left);
            }
        }
        return root.key;
    }


    public static <T extends Comparable<? super T>> BinarySearchTreeGeneric <T> fromSortedArray(T[] input){
        int mid = input.length/2;
        BinarySearchTreeGeneric treeFromSort = new BinarySearchTreeGeneric();
        root = treeFromSort.sortedArrayToBST(input, 0, input.length -1 );
        treeFromSort.inOrder(root);
        return treeFromSort;
    }

    public static <T extends Comparable<? super T>> BinarySearchTreeGeneric <T> fromArray(T[] input){
        BinarySearchTreeGeneric treeFromArray = new BinarySearchTreeGeneric();
        QuickSortGeneric sort = new QuickSortGeneric();
        sort.sort(input, 0, input.length-1);
        root = treeFromArray.sortedArrayToBST(input, 0, input.length -1 );
        treeFromArray.preOrder(root);
        return treeFromArray;
    }


    Node sortedArrayToBST(T arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    public static void main(String[] args) {
        BinarySearchTreeGeneric tree = new BinarySearchTreeGeneric();
        Integer[] arr = {1, 3, 8, 10, 19, 22, 32};
        Integer[] randomArr = {8, 32, 19, 10, 1, 3, 22};
        tree.insert(70);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST

        tree.preOrder(tree.root);

        System.out.println(tree.find(tree.root, 20));
        System.out.println(tree.findMax(tree.root));
        System.out.println(tree.findMin(tree.root));

        fromSortedArray(arr);
        fromArray(randomArr);
    }
}

class Node <T extends Comparable<? super T>>{
    T key;
    Node left, right;

    public Node(T item) {
        key = item;
        left = right = null;
    }
}