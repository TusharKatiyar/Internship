import java.io.IOException;


public class Checked_b {


   static void method() throws IOException {
       throw new IOException("IOException");
   }
   public static void main(String[] args) {
       try {
           method();
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
   }
}
