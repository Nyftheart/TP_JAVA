package tp.therad.concurrence;

public class Test {
    int value;

    public static void main(String[] args) {
        final Test test = new Test();

        for(int i=0; i<2; i++) {
            final int id = i;
            new Thread(new Runnable() {
                public void run() {
                    for(;;) {
                        test.value = id;
                        if (test.value != id)
                            System.out.println("id " + id + " " + test.value);
                    }
                }
            }).start();
        }
    }
}