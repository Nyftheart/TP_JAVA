package tp.therad.CoitusInteruptus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoitusInteruptus implements Runnable {
    private int id;
    private int counter;
    private volatile boolean running = true;
    private volatile boolean paused = false;

    public CoitusInteruptus(int id) {
        this.id = id;
    }

    public void run() {
        while (running) {
            if (!paused) {
                //System.out.println("hello " + id + " " + counter++);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread " + id + " interrupted");
                return;
            }
        }
    }

    public void stopThread() {
        running = false;
    }

    public void pauseThread() {
        paused = true;
    }

    public void resumeThread() {
        paused = false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CoitusInteruptus> threads = new ArrayList<>();

        System.out.print("N° thread: ");
        int numThreads = scanner.nextInt();

        for (int i = 0; i < numThreads; i++) {
            CoitusInteruptus thread = new CoitusInteruptus(i);
            threads.add(thread);
            Thread t = new Thread(thread);
            if (i == 0) {
                t.setPriority(Thread.MAX_PRIORITY);
            } else if (i == numThreads - 1) {
                t.setPriority(Thread.MIN_PRIORITY);
            } else {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            t.start();
        }

        while (true) {
            System.out.print("Enter: ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                for (CoitusInteruptus thread : threads) {
                    thread.stopThread();
                }
                break;
            } else if (input.startsWith("kill")) {
                int id = Integer.parseInt(input.split(" ")[1]);
                threads.get(id).stopThread();
            } else if (input.startsWith("pause")) {
                int id = Integer.parseInt(input.split(" ")[1]);
                threads.get(id).pauseThread();
            } else if (input.startsWith("resume")) {
                int id = Integer.parseInt(input.split(" ")[1]);
                threads.get(id).resumeThread();
            }

        }

        scanner.close();
    }
}
