package huiswerk2020.Generics;

public class Square extends Shape implements Comparable<Square> {
    private double length;
    private double width;

    private Square(double length, double width){
        this.length = length;
        this.width = width;
    }

    public static void main(String[] args){
        Square square = new Square(5, 3);
        Square square1 = new Square(7, 2);

        System.out.println(square.compareTo(square1));
    }

    @Override
    public int compareTo(Square other) {
        return (int)(area() - other.area());
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return length *2 + width * 2;
    }
}
