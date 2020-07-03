public class A {
    public static void main(String[] args) {
        Error error = new Error("error");
        Exception exception = new Exception("exp");
        try {
            throw exception;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            throw exception;
            // throw error;
        } catch (Exception e) {
            System.err.println("in excep");
            System.out.println(e.getMessage());
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        System.out.println(error instanceof Throwable);
        System.out.println(exception instanceof Throwable);
        Planet pl = new Planet();
        pl.describe();
    }

    public void doit() {
        System.out.println("A");
    }
}

interface base {
    boolean m1();

    byte m2(short s);
}

abstract class Class2 implements base {
    public boolean m1() {
        return (7 > 4);
    }
}

abstract class Abstractit {
    abstract float getFloat();
}

// class test1 extends Abstractit {
// private float f1 = 1.01f;

// private float getFloat() {
// return f1;
// }
// }
// class Class2 implements base {
// boolean m1() {
// return (7 > 4);
// }

// byte m2(short s) {
// return 42;
// }
// }
class Animal {
    String name = "no name";

    Animal() {
    }

    Animal(String nm) {
        name = nm;
    }
}

class DomesticAnimal extends Animal {
    String animalfam = "nofam";

    public DomesticAnimal(String family) {
        super(family);
        animalfam = family;
    }
}

interface HeavenlyBody {
    String describe();
}

class Star implements HeavenlyBody {
    String starname;

    public String describe() {
        return "star" + starname;
    }
}

class Planet {
    String name;
    Star orbiting;

    public String describe() {
        return "planet" + name + "orbiting" + orbiting.describe();
    }
}