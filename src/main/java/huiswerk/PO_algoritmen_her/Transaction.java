package huiswerk.PO_algoritmen_her;
public class Transaction {
    private int amount;

    public Transaction(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public String toString(){
        return ""+amount;
    }
}
