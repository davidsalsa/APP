package huiswerk.PO_algoritmen_her;
import huiswerk.lists.HANLinkedList;

public class BlockChain extends HANLinkedList<Transaction> {
    private BlockChainListNode header = null;
    private int size;

    public BlockChain(){
        header = new BlockChainListNode(null, null, 0);
        size = 0;
    }

    public int getBalance(){
        if (size==0)
            return 0;//Geen transacties, we gaan uit van een saldo van 0

        // Het huidige saldo staat altijd vooraan:
        return (header).getBalance();
    }

    public void addTransaction(Transaction transaction){
        //vraag b
        int balance = transaction.getAmount() + header.getBalance();
        BlockChainListNode node = new BlockChainListNode(transaction, header, balance);
        node.setNext(header);
        header = node;
        size = size +1;
    }

    /**
     * Vraag c
     * Validates the complete blockchain; e.g. EVERY node must be the sum of its own and previous transactions.
     * @return true when every node in the chain is the sum of its own and previous transactions.
     */
    public boolean validate(){
        if (size==0)
            return true;

        return false;
    }


    public static void main(String[] arg){
        // Testen voor vraag b

        Transaction a = new Transaction(4);
        Transaction b = new Transaction(5);
        Transaction c = new Transaction(6);

        BlockChain bc = new BlockChain();
        bc.addTransaction(a);
        bc.addTransaction(b);
        bc.addTransaction(c);

        System.out.println("Balance: "+bc.getBalance());
        

        // Testen voor vraag c
        if(bc.validate()){
            System.out.println("Validates!, total balance: "+bc.getBalance());
        } else {
            System.out.println("Error in blockchain. Balance does not match transactions");
        }

        // Evil hacker, removes node in the middle of the list:
        bc.delete(1) ;

        if(bc.validate()){
            System.out.println("Validates!");
        } else {
            System.out.println("Error in blockchain. Balance does not match transactios");
        }
    }
}
