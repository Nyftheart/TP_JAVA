package tp.therad.hellothread;

import java.util.Scanner;

public class HelloThread implements Runnable {
    private int id;
    private int counter;
    private static int numThreads;

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
        Scanner scanner = new Scanner(System.in);

        System.out.print("N° thread: ");
        numThreads = scanner.nextInt();

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new HelloThread(i));
            if (i == 0) {
                thread.setPriority(Thread.MAX_PRIORITY);
            } else if (i == numThreads - 1) {
                thread.setPriority(Thread.MIN_PRIORITY);
            } else {
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            thread.start();
        }

        scanner.close();
    }
}
