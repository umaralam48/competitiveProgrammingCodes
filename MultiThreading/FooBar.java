class FooBar {
    private int n;
    private Boolean foo;

    public FooBar(int n) {
        this.n = n;
        this.foo = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (!foo)
                Thread.sleep(0);
            printFoo.run();
            synchronized (foo) {
                foo = false;
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            while (foo)
                Thread.sleep(0);
            printBar.run();
            synchronized (foo) {
                foo = true;
            }
        }
    }
}