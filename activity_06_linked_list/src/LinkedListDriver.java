import com.sun.security.jgss.GSSUtil;

public class LinkedListDriver {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(3);
//        ll.append(5);
//        ll.append(8);
//        ll.append(2);
        System.out.println(ll);
        ll.remove(0);
        System.out.println(ll);
        System.out.println(ll.isEmpty());
    }
}
