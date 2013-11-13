
package datastruct;

public class TestLinkedList{

    public static void main(String[] args) throws Exception {
        SingleLinkedList list=new SingleLinkedList();
        System.out.println("List is Empty ? "+list.isEmpty());
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("List is Empty ? "+list.isEmpty());
        System.out.println("First Element is "+list.getFirst());
        System.out.println("Last Element is "+list.getLast());
        System.out.println("Size of LinkedList = "+list.getSize());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println("List is Empty ? "+list.isEmpty());
    }
}
