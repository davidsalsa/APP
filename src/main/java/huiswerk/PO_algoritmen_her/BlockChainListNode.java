package huiswerk.PO_algoritmen_her;
import huiswerk.lists.LinkedListNode;

public class BlockChainListNode extends LinkedListNode<Transaction> {
    private int balance;

    public BlockChainListNode(Transaction value, BlockChainListNode next, int balance){
        super(value);
        super.setNext(next);
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }


}
