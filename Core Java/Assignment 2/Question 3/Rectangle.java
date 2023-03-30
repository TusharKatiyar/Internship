public class Rectangle extends Parallelogram {

    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }

    @Override

    public double getArea() {
        double base = Math.sqrt(Math.pow(getP1().getX() - getP2().getX(), 2) + Math.pow(getP1().getY() - getP2().getY(), 2));
        double height = Math.sqrt(Math.pow(getP2().getX() - getP3().getX(), 2) + Math.pow(getP2().getY() - getP3().getY(), 2));
        return base * height;
    }

    public String Answer(){
        return "\nCoordinates of Rectangle are:\n" + super.toString()
        + "\nArea is :" + getArea();
    }
}
