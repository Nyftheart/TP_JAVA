package tp.therad.concurrence;

import java.util.concurrent.atomic.AtomicInteger;

public class Synconiser { // ceci est une tentative pas forcément sur que cela marche
    AtomicInteger value;

    public Synconiser() {
        this.value = new AtomicInteger();
    }

    public static void main(String[] args) {
        final Synconiser test = new Synconiser();

        for(int i=0; i<2; i++) {
            final int id = i;
            new Thread(new Runnable() {
                public void run() {
                    for(;;) {
                        test.value.set(id);
                        if (test.value.get() != id)
                            System.out.println("id " + id + " " + test.value.get());
                    }
                }
            }).start();
        }
    }
}
