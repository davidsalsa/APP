package huiswerk.lists;

public class BalancedSymbolChecker {

    private HANLinkedList<String> list = new HANLinkedList();

    public boolean checker(String symbol) {

        HANStack hanStack = new HANStack(list);
        for (int i = 0; i < symbol.length(); i++) {
            if (symbol.charAt(i) == '(') {
                hanStack.push("(");
            }
            if (symbol.charAt(i) == ')' && hanStack.top() == "(") {
                hanStack.pop();
            }
        }
        if (list.first == null) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        String symbolBalanced = "()";
        String symbolBalanced2 = "(())";
        String symbolUnbalanced = "())";
        BalancedSymbolChecker balancedSymbolChecker = new BalancedSymbolChecker();
        System.out.println(balancedSymbolChecker.checker(symbolBalanced));
        System.out.println(balancedSymbolChecker.checker(symbolBalanced2));
        System.out.println(balancedSymbolChecker.checker(symbolUnbalanced));
    }

}
