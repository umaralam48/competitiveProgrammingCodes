class Foo {

    private Integer counter;

    public Foo() {
        this.counter = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {

        while (counter != 1)
            ;
        synchronized (counter) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            counter++;
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (counter != 2)
            ;
        synchronized (counter) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printSecond.run();
            counter++;
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (counter != 3)
            ;
        synchronized (counter) {
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            counter++;
        }

    }
}