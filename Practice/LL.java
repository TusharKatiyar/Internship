import java.util.*;;

public class LL{
    public static void main(String args[]){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListIterator<Integer> it = list.listIterator(list.size());
        while(it.hasPrevious()){
            System.out.println(it.previous());
        }
    
    }
}
