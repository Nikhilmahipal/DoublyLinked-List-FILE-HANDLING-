package doublylinkedlist;

public class Node {
    private String data;
    public Node previous;
    public Node next;
    
    public Node(String data){
        previous=null;
        this.data=data;
        next=null;
    }
    public Node(Node previous,String data,Node next){
        this.previous=previous;
        this.data=data;
        this.next=next;
    }
    public void setLinkPrev(Node previous){
        this.previous=previous;
    }
    public void setLinkNext(Node next){
        this.next=next;
    }
    public Node getLinkNext(){
        return next;
    }
    public Node getLinkPrev(){
        return previous;
    }
    
    public String Data(){
        return data;
    }
}
