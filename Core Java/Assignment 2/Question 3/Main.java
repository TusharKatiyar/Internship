public class Main {
    public static void main(String[] args) {

        Trapezoid trapezoid = new Trapezoid(5,5,10,5,8,10,7,10);
        Parallelogram parallelogram = new Parallelogram(5.0, 5.0, 11.0, 5.0, 12.0, 20.0, 6.0, 20.0);
        Rectangle rectangle = new Rectangle(17.0, 14.0, 30.0, 14.0, 30.0, 28.0, 17.0, 28.0);
        Square square = new Square(4.0, 0.0, 8.0, 0.0, 8.0, 4.0, 4.0, 4.0);

        // System.out.println(trapezoid);
        // System.out.println(parallelogram);
        // System.out.println(rectangle);
        // System.out.println(square);

        System.out.println(trapezoid.Answer());
        System.out.println(parallelogram.Answer());
        System.out.println(rectangle.Answer());
        System.out.println(square.Answer());

    }
}
