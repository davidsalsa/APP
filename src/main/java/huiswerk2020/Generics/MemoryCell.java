package huiswerk2020.Generics;

public class MemoryCell implements Comparable<MemoryCell>{
    private int storedValue;

    public int read( ){
        return storedValue;
    }
    public void write( int x ) {
        storedValue = x;
    }

    @Override
    public int compareTo(MemoryCell o) {
        return storedValue - o.storedValue;
    }
}
