import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private int turn;

    public ZeroEvenOdd(int n) {
        this.n = n;
        turn = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean odd = true;
        while (n > 0) {
            n--;
            while (turn != 0 && n > 0)
                Thread.sleep(0);
            if (n <= 0)
                return;
            printNumber.accept(0);
            if (odd) {
                odd = false;
                turn = 1;
            } else {
                odd = true;
                turn = 2;
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int num = 2;
        while (n > 0) {
            while (turn != 2 && n > 0)
                Thread.sleep(0);
            if (n <= 0)
                return;
            printNumber.accept(num);
            num += 2;
            turn = 0;
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int num = 1;
        while (n > 0) {
            while (turn != 1 && n > 0)
                Thread.sleep(0);
            if (n <= 0)
                return;
            printNumber.accept(num);
            num += 2;
            turn = 0;
        }

    }
}