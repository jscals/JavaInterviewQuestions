public class Node{
    
    public int value;
    private Node leftChild;
    private Node rightChild;
    
    
    public Node(int value){
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node getLeftChild(){
        return this.leftChild;
    }
    
    public void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    }
    
    public Node getRightChild(){
        return this.rightChild;
    }
    
    public void setRightChild(Node rightChild){
        this.rightChild = rightChild;
    }
}