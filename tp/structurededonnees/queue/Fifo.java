package tp.structurededonnees.queue;

public class Fifo {
    private Object[] data;
    private int head;
    private int tail;

    public Fifo(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Max size must be positive");
        }
        data = new Object[size];
        head = -1;
        tail = -1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % data.length == head;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (tail >= head) {
            return tail - head + 1;
        } else {
            return data.length - head + tail + 1;
        }
    }

    public void offer(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Null elements are not allowed");
        }
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (head == -1) {
            head = 0;
        }
        tail = (tail + 1) % data.length;
        data[tail] = o;
    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = (int) data[head];
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % data.length;
        }
        return value;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            int i = head;
            while (i != tail) {
                System.out.print(data[i] + ", ");
                i = (i + 1) % data.length;
            }
            System.out.println(data[tail] + "]");
        }
    }
}
