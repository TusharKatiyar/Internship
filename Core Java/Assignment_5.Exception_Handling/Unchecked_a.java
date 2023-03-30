public class Unchecked_a {
  public static void main(String[] args) {
      try {
          throw new ArithmeticException("ArithmeticException");
      } catch (ArithmeticException e) {
          System.out.println(e.getMessage());
      }
  }
}
