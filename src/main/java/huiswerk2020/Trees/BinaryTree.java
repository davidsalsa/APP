package huiswerk2020.Trees;

public class BinaryTree<T extends Comparable<T>>
{
    // Root of Binary Tree
    Node root;

    BinaryTree()
    {
        root = null;
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();


        tree.root = new Node<>(3);

        tree.root.right  = new Node<>(4);

        tree.root.left = new Node<>(1);
        tree.root.left.left = new Node<>(0);
        tree.root.left.right = new Node<>(2);

    }


// only works with BST
    public Node findNode(T value){
        if(root == null){
            return null;
        }
        return root.findNodeRecursively(value);
    }
}