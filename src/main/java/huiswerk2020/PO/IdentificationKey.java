package huiswerk2020.PO;

public class IdentificationKey<T> {

    public IdentificationNode<T> root;
    public IdentificationNode<T> cur;

    public IdentificationKey(){
        this.root = null;
    }

    public IdentificationKey(IdentificationNode<T> node){
        this.root = node;
    }

    public static void main(String[] args){
        IdentificationKey<Animal> key = new IdentificationKey<>();
        key.root = new IdentificationNode<>("Leeft het op het land?");
        key.root.setLeft(new IdentificationNode<>(new Animal("Dolfijn")));
        key.root.setRight(new IdentificationNode<>("Eet het fruit?"));
        key.root.right.setLeft(new IdentificationNode<>(new Animal("Olifant")));
        key.root.right.setRight(new IdentificationNode<>(new Animal("Aap")));

        key.start();
        System.out.println(key.getQuestion());
        key.navigate(true);
        System.out.println(key.getQuestion());
        key.navigate(false);

        if(key.found()){
            System.out.println(key.getSpecies().toString());
        }

        key.start();
        System.out.println(key.getQuestion());
        key.navigate(false);

        if(key.found()){
            System.out.println(key.getSpecies().toString());
            key.extend("Heeft het kieuwen?", new Animal("Tonijn"));
            key.navigate(true);
            System.out.println(key.getSpecies());
        }
    }

    public void start(){
        cur = root;
    }

    public String getQuestion(){
     return cur.question;
    }

    public void navigate(boolean answer){
        if(answer){
            cur = cur.right;
        } else {
            cur = cur.left;
        }
    }

    public boolean found(){
        return getSpecies() != null;
    }

    public T getSpecies(){
        return cur.species;
    }

    public void extend(String question, T species){
        cur.setLeft(cur);
        cur.species = null;
        cur.question = question;
        cur.setRight(new IdentificationNode<>(species));
    }

}
