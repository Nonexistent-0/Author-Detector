public class LinkedList {
    
    private Node head;
    private int size;
    
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public int size() {
        return size;
    }
    
    public void add(String val) {
        if (isEmpty()) {
            head = new Node(val);
            size++;
        } else {
            Node temp = head;
            while (true) {
                if (temp.getVal().equals(val)) {
                    temp.increment();
                    break;
                } else if (temp.getNext() == null) {
                    temp.setNext(new Node(val));
                    size++;
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
        }
    }
    
    public String get(int pos) {
        if (isEmpty()) {
            return null;
        } else if ((pos < 0) || (pos >= size)) {
            return null;
        } else if (pos == 0) {
            return head.getVal();
        }
        
        Node temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.getNext();
        }
        
        return temp.getNext().getVal();
    }
    
    public String remove(int pos) {
        if (isEmpty()) {
            return null;
        } else if ((pos < 0) || (pos >= size)) {
            return null;
        } 
        else if (pos == 0) {
            Node temp = head;
            head = head.getNext();
            size--;
            return temp.getVal();
        }
        
        Node temp = head;
        for (int i = 0; i < pos-1; i++) {
            temp = temp.getNext();
        }
        
        String val = temp.getNext().getVal();
        temp.setNext(temp.getNext().getNext());
        
        size--;
        return val;
    }
    
    public int contains(String val) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.getVal().equals(val)) {
                return i;
            }
            temp = temp.getNext();
        }
        
        return -1;
    }

    public boolean removeFirst(String val) {
        int pos = contains(val);
        if (pos == -1) {
            return false;
        }
        remove(pos);
        return true;
    }
    
    public void insert(int pos, String val) {
        if (pos < 0) {
            pos = 0;
        } else if (pos > size) {
            pos = size;
        }
        if (pos == 0) {
            Node temp = head;
            head = new Node(val);
            head.setNext(temp);
            size++;
            return;
        }
        Node before = head;
        for (int i = 0; i < pos - 1; i++) {
            before = before.getNext();
        }
        Node after = before.getNext();
        before.setNext(new Node(val));
        before.getNext().setNext(after);
        size++;
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }

        String msg = "[" + head.getVal();
        Node next = head;
        
        for (int i = 0; i < size - 1; i++) {
            next = next.getNext();
            msg += ", " + next.getVal();
        }
        
        System.out.println(msg +"]");
    }
    
}