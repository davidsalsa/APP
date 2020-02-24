package huiswerk2020.Trees;


class Tree<T> {  // implements Iterable<T> {
    private T label;
    private Tree<T> parent;
    private Tree<T> nextSibling; // next node on the list of parents's
    //  children
    private Tree<T> firstChild;  // first in the linked list of children


    public Tree(T label){
        this.label=label;
    }

    //  Getters and setters
    public T getLabel() { return label; }
    public void setLabel(T v) { label = v; }
    public Tree<T> getParent() { return parent;}
    public Tree<T> getNextSibling() { return nextSibling;}
    public Tree<T> getFirstChild() { return firstChild;}

    // Add C to the front of the children of this
    public void addChild(Tree<T> c) {
        c.parent = this;
        if (firstChild == null)
            firstChild = c;
        else {
            c.nextSibling = firstChild;
            firstChild = c;
        }
    }

    // Check if the node is a leaf
    public boolean Leaf() { return firstChild==null; }

    // `Convert the tree into a string. The structure is indicated by
// square brackets. Uses a preorder listing.
    public String toString() {
        String S = "[ " + label.toString();
        Tree<T> N = firstChild;
        while (N != null) {
            S = S + " " + N.toString();
            N = N.nextSibling;
        }
        return S+" ]";
    }

    public void displayPreorder() {
        displayPreorder1(0); }

    public void displayPreorder1(int Indent) {
        for (int I = 0; I < Indent; I++) System.out.print(" ");
        System.out.println(label.toString());
        Tree<T> N = firstChild;
        while (N != null) {
            N.displayPreorder1(Indent+3);
            N = N.nextSibling;
        }
    }

    public void displayPostorder() {
        displayPostorder1(0); }

    public void displayPostorder1(int Indent) {
        Tree<T> N = firstChild;
        while (N != null) {
            N.displayPostorder1(Indent+3);
            N = N.nextSibling;
        }
        for (int I = 0; I < Indent; I++) System.out.print(" ");
        System.out.println(label.toString());
    }

    public static void main(String[] args){
        Tree tree = new Tree("parent");
        Tree child = new Tree("child");
        Tree child2 = new Tree("child2");
        Tree sibling = new Tree("sibling");
        tree.addChild(child);
        child.addChild(child2);
        tree.addChild(sibling);
        tree.displayPreorder();

    }
}