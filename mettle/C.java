public class C extends B {
    public static void main(String[] args) {
        C obj = new C();
        obj.cdoit();
    }

    @Override
    public void doit() {
        System.out.println("C");
    }

    public void cdoit() {
        A a = new A();
        A h = this;
        h.doit();
        // A.this.doit();
        super.doit();
        doit();
    }
}

class B extends A {
    @Override
    public void doit() {
        System.out.println("B");
    }
}