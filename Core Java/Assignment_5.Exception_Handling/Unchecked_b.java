public class Unchecked_b {


  static void method() throws ArithmeticException {
      throw new ArithmeticException("ArithmeticException");
  }
  public static void main(String[] args) {
      try {
          method();
      } catch (ArithmeticException e) {
          System.out.println(e.getMessage());
      }
  }
}
