public class HashTable {

    LinkedList[] values;
    int load;

    public HashTable() {
        values = createArray(16);
        load = 0;
    }

    private int hash(String str) {
        int hash = 0;
        final int prime = 31;  
        
        for (int i = 0; i < str.length(); i++) {
            hash = prime * hash + str.charAt(i);
        }
        
        return Math.abs(hash % values.length); 
    }

    public void put(String str) {

        int index = hash(str);
        if (load > (values.length * .75)) {
            grow();
        }
        
        load++;
        values[index].add(str);

    }

    private void grow() {
        LinkedList[] temp = createArray(values.length * 2);
        for (LinkedList list : values) {
            for (int i = 0; i < list.size(); i++) {
                temp[hash(list.get(i))].add(list.get(i));
            }
        }
        values = temp;
    }

    public boolean contains(String val) {
        if (values[hash(val)].contains(val) != -1) {
            return true;
        }
        return false;
    }

    public boolean remove(String str) {
        load--;
        return values[hash(str)].removeFirst(str);
    }

    private LinkedList[] createArray(int l) {
        LinkedList[] temp = new LinkedList[l];
        for (int i = 0; i < l; i++) {
            temp[i] = new LinkedList();
        }
        return temp;
    }

    public void printInOrder() {
        for (LinkedList list : values) {
            list.print();
        }
    }



}