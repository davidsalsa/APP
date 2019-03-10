package huiswerk.trees;

class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
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

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
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
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        tree.inorder();

        System.out.println(tree.find(tree.root, 20));
        System.out.println(tree.findMax(tree.root));
        System.out.println(tree.findMin(tree.root));
    }
}