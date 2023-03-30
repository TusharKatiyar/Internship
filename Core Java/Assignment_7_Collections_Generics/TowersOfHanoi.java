import java.util.*;

public class TowersOfHanoi {

    public static int n = 3;
        
    @SuppressWarnings("unchecked")
    public static Stack<Integer>[] towers = new Stack[3];
    static  char[] ch=new char[]{'A','B','C'};

    public static void main(String[] args) {
       
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<Integer>();
        }
        for (int i = n; i > 0; i--) {
            towers[0].push(i);
        }
        moveDisks(n, towers[0], towers[1], towers[2], 0, 1, 2);
    }

    public static void moveDisks(int n, Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination, int a, int b, int c) {
        if (n <= 0) {
            return;
        }
        moveDisks(n - 1, origin, destination, buffer, a, c, b);  //`n-1` disks from origin to buffer, using destination as a buffer
        destination.push(origin.pop());
        System.out.println("Move disk " + n + " from " + ch[a] + " to " + ch[c]);
        moveDisks(n - 1, buffer, origin, destination, b, a, c); //`n-1` disks from buffer to destination, using origin as a buffer
    }   
}

