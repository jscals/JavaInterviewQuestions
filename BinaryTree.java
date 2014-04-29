public class BinaryTree{
    
    private Node head; 
    
    
    public BinaryTree(){
        this.head = null;
    }   
    public BinaryTree(Node head){
        this.head = head;
    }
    
    
    public Node getHead(){
        return this.head;
    }
    
    public void setHead(Node head){
        this.head = head;
    }
}
