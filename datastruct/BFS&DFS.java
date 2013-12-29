import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
       Graph g=new Graph(new Node(100));
       Graph g2=new Graph(new Node(200));
       Graph g3=new Graph(new Node(201));
       g2.addChild(new Node(300));
       g2.addChild(new Node(301));
       g2.addChild(new Node(302));
       g2.addChild(new Node(303));
       g3.addChild(new Node(304));
       g3.addChild(new Node(305));
       g3.addChild(new Node(306));
       g3.addChild(new Node(307));
       g.addChild(g2);
       g.addChild(g3);
       System.out.println("BFS:");
       //bfs(g);
       System.out.println("DFS:");
       dfs(g);
    }
    
    static void bfs(Graph g){
        Queue<Graph> qu=new LinkedList();
        qu.add(g);
        while(!qu.isEmpty()){
            Graph temp=qu.remove();
            System.out.println(temp.getRootNode().getId());
            HashSet<Graph> childs=temp.getChildSet();
            for(Graph child : childs){
                qu.add(child);
            }
        }
    }
    
    static void dfs(Graph g){
        if(g.count()==0){
            System.out.println(g.getRootNode().getId());
            return;
        }
        for(Graph child : g.getChildSet()){
            dfs(child);
        }
        System.out.println(g.getRootNode().getId());
    }
}

class Node {

    private int id;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Graph {

    private HashSet<Graph> childs = new HashSet<Graph>();
    private Node rootNode;
    
    public Graph(Node node) {
        this.rootNode = node;
    }
    
    public HashSet<Graph> getChildSet() {
        return childs;
    }

    public void addChild(Graph g) {
        childs.add(g);
    }

    public void addChild(Node node) {
        Graph g = new Graph(node);
        childs.add(g);
    }

    public Node getRootNode() {
        return rootNode;
    }

    public int count() {
        return childs.size();
    }

    public String toString() {
        String temp = rootNode.getId() + " => {";
        for (Graph child : childs) {
            temp += child.toString() + ", ";
        }
        temp += "}";
        return temp;
    }
}
