
package datastruct;

public class Node{
    private int data;
    private Node next;
    Node(){
        data=1;
        next=null;
    }
    
    Node(int val){
        data=val;
        next=null;
    }
    
    public void setNext(Node n){
        next=n;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public int getData(){
        return this.data;
    }
   
}