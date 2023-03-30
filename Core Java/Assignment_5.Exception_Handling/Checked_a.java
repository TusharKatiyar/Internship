import java.io.IOException;

public class Checked_a {
   public static void main(String[] args) {
       try {
           throw new IOException("IOException");
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
   }
}
