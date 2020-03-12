package huiswerk2020.PO;

public class IdentificationNode<T> {
    public IdentificationNode<T> right;
    public IdentificationNode<T> left;
    public T species;
    public String question;

    public IdentificationNode(String question){
        this.question = question;
    }

    public IdentificationNode(T species){
        this.species = species;
    }

    public void setLeft(IdentificationNode<T> node){
        left = node;
    }

    public void setRight(IdentificationNode<T> node){
        right = node;
    }
}
