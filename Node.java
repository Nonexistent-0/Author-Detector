public class Node {
    
    private String val;
    private Node next;
    private int amount;
    
    public Node(String val) {
        this.val = val;
        this.next = null;
        this.amount = 0;
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

    public void increment() {
        amount++;
    }

    public int getAmount() {
        return amount;
    }
    
}