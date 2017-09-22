package exercise2;

/**
 *
 * @author Andrian Vangelov
 */
class Even {

    private int n = 0;

    public int next() {
        n++;
        n++;
        return n;
    }
}

public class Exercise2 {

    public static void main(String[] args) {

        Even eve = new Even();
        int forTheLoop = 30000;
        System.out.println("Every thread will call \"next()\" method for: "+forTheLoop+" times.");
        System.out.println("If there is no message below this line, threads are working synchronously. ");

        //thread 1
        Thread t1 = new Thread(() -> {
            for (int p = 0; p < forTheLoop; p++) {
                if (eve.next() % 2 != 0) {
                    System.out.println("Not even! (t1) for: "+p+" loops.");
                    break;
                }
            }
        });

        //thread 2
        Thread t2 = new Thread(() -> {
            for (int p = 0; p < forTheLoop; p++) {
                if (eve.next() % 2 != 0) {
                    System.out.println("Not even! (t2) for: "+p+" loops.");
                    break;
                }
            }
        });

        t1.start();
        t2.start();
    }
}
