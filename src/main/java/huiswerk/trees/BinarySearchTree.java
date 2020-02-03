package huiswerk.trees;

public class BinarySearchTree<T> {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
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

    private static int subtract(BinarySearchTree<Integer> bt) {
        int res = 0;

        if(bt.root == null){
            return 0;
        }

        res = subtractRec(bt.root, res).key;

        return res;
    }

    private static Node subtractRec(Node root, int res){
        if(root.left != null){
            root.key = root.key - root.left.key;
            root = subtractRec(root.left, root.key);
        }
        if(root.right != null){
            root.key = root.key - root.right.key;
            root = subtractRec(root.right, root.key);
        }

        return root;
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(" " + node.key);
        }
    }

    Node find(Node root, int value) {
        if (root != null) {
            if (root.key > value) {
                root = find(root.left, value);
            } else if (root.key < value) {
                root = find(root.right, value);
            }

        } else throw new Error("Given value does not exist in this tree.");
        return root;
    }

    int findMax(Node root) {
        if (root != null) {
            if (root.right != null) {
                root.key = findMax(root.right);
            }
        }
        return root.key;
    }

    int findMin(Node root) {
        if (root != null) {
            if (root.left != null) {
                root.key = findMin(root.left);
            }
        }
        return root.key;
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree<Integer>();

        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);



        System.out.println("preOrder:");
        tree.preOrder(tree.root);

        System.out.println(subtract(tree));

//        System.out.println("inOrder:");
//        tree.inOrder(tree.root);

//        System.out.println("postOrder:");
//        tree.postOrder(tree.root);
//        System.out.println(tree.find(tree.root, 20));

    }
}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}