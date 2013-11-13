
package datastruct;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;


    public SingleLinkedList() {
        size=0;
        head=null;
        tail=null;
    }
    
    public void add(int x){
        if(size==0){
            head=new Node(x);
            tail=head;
            size++;
        }else{
            tail.setNext(new Node(x));
            tail=tail.getNext();
            size++;
        }
    }
    
    public int removeFirst() throws Exception{
        if(size==0){
            Exception ex=new Exception("Removing from an empty Linked List");
            throw ex;
        }else{
            Node temp=new Node(head.getData());
            head=head.getNext();
            size--;
            return temp.getData();
        }
    }
    
    public int getFirst(){
        return head.getData();
    }
    
    public int getLast(){
        return tail.getData();
    }
    
    public int getValue(int index){
        if(index<size){
            Node temp=head;
            for(int i=0;i<index;i++){
                temp=temp.getNext();
            }
            return temp.getData();
        }else{
            return -1;
        }
    }
    
    public int getSize(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
}


