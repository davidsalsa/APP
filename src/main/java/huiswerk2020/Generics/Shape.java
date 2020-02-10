package huiswerk2020.Generics;

public abstract class Shape {

    public abstract double area();
    public abstract double perimeter();
    public double semiperimeter(){
        return perimeter( ) / 2;
    }
}
