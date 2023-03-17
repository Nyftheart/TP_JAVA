package tp.structurededonnees.queue;


import java.util.ArrayList;

public class Fifo {

    private ArrayList<Object> elements;
    private int maxSize;

    public Fifo(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException();
        }
        this.elements = new ArrayList<Object>();
        this.maxSize = maxSize;
    }

    public void offer(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (this.elements.size() == this.maxSize) {
            throw new IllegalStateException();
        }
        this.elements.add(element);
    }

    public Object poll() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.elements.remove(0);
    }

    public int size() {
        return this.elements.size();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.elements.size(); i++) {
            sb.append(this.elements.get(i));
            if (i < this.elements.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
