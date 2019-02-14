package huiswerk.generics.boekopdrachten;

    import java.lang.*;

    abstract class Shape {
        public abstract double area();
    }

    class Square extends Shape implements Comparable<Square> {
        @Override
        public int compareTo(Square other) {
            if (this.area() < other.area()) {
                return -1;
            }
            if (this.area() > other.area()) {
                return 1;
            }
            return 0;
        }

        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double area() {
            return side * side;
        }
    }

    class vraag33 {
        public static void main(String[] args) throws java.lang.Exception {
            Square square = new Square(2.0);
        }
    }

