public class TwoThreads {
    public static void main(String[] args) {
        ThreadDemo foo = new ThreadDemo();
        Thread t1 = new Thread(foo, "T1");
        Thread t2 = new Thread(foo, "T2");
        // prints main is running while for t1.start() both threads run with their
        // names.
        t1.start();
        t2.start();

    }
}

class ThreadDemo implements Runnable {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " is running : " + i);
        }
    }

}