package huiswerk.lists;

public class BalancedSymbolChecker {

    public boolean checker(String symbol) {

        HANStack<String> hanStack = new HANStack<>();
        for (int i = 0; i < symbol.length(); i++) {
            if (symbol.charAt(i) == ')' && hanStack.top()==null) {
                return false;
            }
            if (symbol.charAt(i) == '(') {
                hanStack.push("(");
            }
            if (symbol.charAt(i) == ')' && hanStack.top().equals("(")) {
                hanStack.pop();
            }
        }
        return hanStack.top() == null;
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
