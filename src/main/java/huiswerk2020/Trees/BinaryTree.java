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
        tree.root.right.right = new Node<>(4);
        tree.root.left = new Node<>(1);
        tree.root.left.left = new Node<>(0);
        tree.root.left.right = new Node<>(2);

        System.out.println("leaves: " + tree.getNumberOfLeaves(tree.root));
        System.out.println("one child: " + tree.getNumberOfNodesWithOneChild(tree.root));
        System.out.println("two children: " + tree.getNumberOfNodesWithTwoChildren(tree.root));
    }


    public int getNumberOfLeaves(Node root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        return getNumberOfLeaves(root.left) + getNumberOfLeaves(root.right);
    }

    public int getNumberOfNodesWithOneChild(Node root){
        if(root == null){
            return 0;
        }
        if(root.left != null ^ root.right != null){
            return 1;
        }
        return getNumberOfNodesWithOneChild(root.left) + getNumberOfNodesWithOneChild(root.right);
    }

    public int getNumberOfNodesWithTwoChildren(Node root){
        if(root == null){
            return 0;
        }
        if(root.left != null && root.right != null){
            return 1;
        }
        return getNumberOfNodesWithOneChild(root.left) + getNumberOfNodesWithOneChild(root.right);
    }

// only works with BST
    public Node findNode(T value){
        if(root == null){
            return null;
        }
        return root.findNodeRecursively(value);
    }
}