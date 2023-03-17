package tp.therad.hellothread;

public class HelloThread implements Runnable {
    private int id;
    private int counter;

    public HelloThread(int id) {
        this.id = id;
    }

    public void run() {
        while (true) {
            System.out.println("hello " + id + " " + counter++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new HelloThread(0));
        Thread t2 = new Thread(new HelloThread(1));
        t1.start();
        t2.start();
    }
}
