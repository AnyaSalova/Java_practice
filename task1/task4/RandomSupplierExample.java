package task4;

import java.util.function.Supplier;
import java.util.Random;

public class RandomSupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(11);
        
        System.out.println("Случайное число: " + randomSupplier.get());
        System.out.println("Случайное число: " + randomSupplier.get());
        System.out.println("Случайное число: " + randomSupplier.get());
    }
}