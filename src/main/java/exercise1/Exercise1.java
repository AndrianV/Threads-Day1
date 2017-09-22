package exercise1;

/**
 *
 * @author Andrian Vangelov
 */

public class Exercise1 {

    private volatile static boolean stopT3 = false;

    public static void main(String[] args) {

        //Thread 1 - Compute and print the sum of all numbers from 1 to 1 billion.
        Thread t1 = new Thread(() -> {
            long sum = 0l;
            for (long i = 1l; i <= 1000000000l; i++) {
                sum += i;
            }
            System.out.println("Thread 1 ready with the summing operation:");
            System.out.println("t1 The SUM is : " + sum);
        });

        //Thread 2 -  Print the numbers from 1 to 5. Pause for 2 seconds between each print.
        Thread t2 = new Thread(() -> {
            for (long i = 1l; i <= 5l; i++) {
                System.out.println("t2 Printing Number : " + i);
                if (i == 5l) {
                    System.out.println("t2 finished!");
                    return;
                }
                try {
                    System.out.println("thread t2 sleeping for 2 sec.");
                    Thread.sleep(2000l);
                } catch (InterruptedException ex) {
                    System.out.println("InterruptedException occurred! t2");
                }
            }
        });

        //Thread 3 - Print all numbers from 10 and up. Pause for 3 seconds between each print.
        Thread t3 = new Thread(() -> {
            long i = 10l;
            while (!stopT3) {
                System.out.println("t3 From 10 and up: " + i);
                i++;
                try {
                    System.out.println("thread t3 sleeping for 3 sec.");
                    Thread.sleep(3000l);
                } catch (InterruptedException ex) {
                    System.out.println("InterruptedException occurred! t3");
                }
            }
        });

        //Starting the Threads
        t1.start();
        t2.start();
        t3.start();
        try {
            System.out.println("Main thread entering sleep mode for 10 sec.");
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occurred! mainM");
        }
        System.out.println("Main thread finished sleeping for 10 sec.");
        System.out.println("Terminating thread 3");
        //stop code here (hint: use boolean to stop thread#3)
        stopT3 = true;
        System.out.println("Thread 3 terminated !");
    }
}
