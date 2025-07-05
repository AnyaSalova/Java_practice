package task4;

public class PrintableExample {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Hello from lambda!");
        printable.print();
    }
}

@FunctionalInterface
interface Printable {
    void print();
}