import java.util.*;

public class practice1{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        list.remove(2);
        System.out.println("After removing the third element:");
        it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        list.add(2, 3);
        System.out.println("After adding 3 to the third element:");
        it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        list.add(2,4);
        System.out.println("After adding 3 to the third element again:");

        it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        
        Collections.sort(list);
        System.out.println("After sorting the list:");
        it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        System.out.println(list);
    }
}