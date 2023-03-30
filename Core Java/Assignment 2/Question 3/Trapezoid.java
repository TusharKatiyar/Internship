public class Trapezoid extends Quadrilateral {

    public Trapezoid(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }

    @Override

    public double getArea() {
        double base1 = Math.sqrt(Math.pow(getP1().getX() - getP2().getX(), 2) + Math.pow(getP1().getY() - getP2().getY(), 2));
        double base2 = Math.sqrt(Math.pow(getP3().getX() - getP4().getX(), 2) + Math.pow(getP3().getY() - getP4().getY(), 2));
        double height = Math.sqrt(Math.pow(getP1().getX() - getP1().getX(), 2) + Math.pow(getP1().getY() - getP4().getY(), 2));
        return (base1 + base2) * height / 2;
    }

    public String Answer(){
        return "\nCoordinates of Trapezoid are:\n" + super.toString()
        + "\nArea is :" + getArea();
    }
}
