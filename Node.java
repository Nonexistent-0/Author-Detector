public class Node {
    
    private String val;
    private Node next;
    
    public Node(String val) {
        this.val = val;
        this.next = null;
    }
    
    public String getVal() {
        return val;
    }
    
    public void setNext(Node n) {
        next = n;
    }
    
    public Node getNext() {
        return next;
    }
    
}