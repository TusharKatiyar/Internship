import java.util.*;

public class ListConcatenate {
    public static void main(String[] args) {
        List<Character> list1 = new LinkedList<>();
        List<Character> list2 = new LinkedList<>();
        list1.add('A');
        list1.add('B');
        list1.add('C');
        list2.add('D');
        list2.add('E');
        list2.add('F');
        concatenate(list1, list2);
        System.out.println(list1);
    }

    public static void concatenate(List<Character> list1, List<Character> list2) {
        list1.addAll(list2);
    }
}