package doublylinkedlist;

import static doublylinkedlist.Main.output;
import java.io.IOException;

/**
 *
 * @author sahut
 */
public class doublylinkedlist {
    
    private Node head;
    private int size;
    
    public doublylinkedlist(){
        head=null;
        size=0;
    }
 
    public void addFront(String data){
        if(head==null){
            head=new Node(null,data,null);
        }
        else{
            Node new_Node=new Node(data);
            head.previous=new_Node;
            head=new_Node;
        }
        size++;
    }
    
    public void addRear(String data){
        
        
            if(head==null){
                head=new Node(null,data,null);
            }
            else{
                Node current = head;
                while(current.next != null){
                    current=current.next;
                    
                }
                Node new_Node= new Node(current,data,null);
                current.next=new_Node;
                
            }
            size++;
    }
    
    public void removeFront(){
        if(head==null){
            return;
        }
        head=head.next;
         head.previous=null;
        size--;
    }
    
    public void removeRear(){
        if(head.next == null){
            head=null;
            size--;
            return;
        }
        Node current=head;
        while(current.next.next !=null){
            current=current.next;
        }
        current.next=null;
        size--;
    }
    
    public void deleteAnyElement(int index){
        if(head==null)
            return;
        if(index<1 || index>size)
            return;
        int i=1;
        Node current=head;
        while(i<index){
            current=current.next;
            i++;
        }
        if(current.next==null){
            current.previous.next=null;
            
        }
        else if(current.previous==null){
            current=current.next;
            current.previous=null;
            head=current;
        }
        else{
            current.previous.next=current.next;
            current.next.previous=current.previous;
        }
    }
    public void deleteAnyData(String data){
        if(head==null){
            return;
        }
        Node current=head;
        while(!(current.Data().contains(data))){
            current=current.next;
        }
        if(current.next==null){
            current.previous.next=null;
            
        }
        else if(current.previous==null){
            current=current.next;
            current.previous=null;
            head=current;
        }
        else{
            current.previous.next=current.next;
            current.next.previous=current.previous;
        }
        
    }
    
    
    public void insertAtanyPos(String data){
    //    Node current=head;
        Node new_Node=new Node(null,data,null);
        Node tmp;
        Node ptr;
        boolean ins = false;
        if(head==null)
            head=new_Node;

        else if(Integer.parseInt(data)<=Integer.parseInt(head.Data())){
        //    Node new_node=new Node(null,data,current)
            new_Node.setLinkNext(head);
            head.setLinkPrev(new_Node);
            
        //    current.previous = new_Node;
            head=new_Node;
        }
        else{
            tmp=head;
            ptr=head.getLinkNext();
            
            while(ptr != null){
                
                if(Integer.parseInt(data)>Integer.parseInt(tmp.Data()) && Integer.parseInt(data)<=Integer.parseInt(ptr.Data())){
                //    Node new_Node =new Node(current.previous,data,current);
                    tmp.setLinkNext(new_Node);
                    new_Node.setLinkPrev(tmp);
                    new_Node.setLinkNext(ptr);
                    ptr.setLinkPrev(new_Node);
                    ins = true;
                    break;               
                }
                else{
                    tmp=ptr;
                    ptr=ptr.getLinkNext();
                    
                }
            }
                if(!ins){

                    tmp.setLinkNext(new_Node);
                    new_Node.setLinkPrev(tmp);
                    
                }
        }
        size++;
    }
    public void reverse(){
        Node temp=null;
        Node current=head;
        while(current !=null){
            temp=current.previous;
            current.previous=current.next;
            current.next=temp;
            current=current.previous;
        }
    }
    public void print() throws IOException{
        Node current=head;
        while(current !=null){
            output.write(current.getLinkPrev()+" "+current+" "+current.Data()+ " "+current.getLinkNext());
            current=current.next;
        }   
    }
    public boolean isEmpty(){
        return head == null;
    }
    }

