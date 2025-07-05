package task4;

import java.util.function.Function;

public class NumberCheckExample {
    public static void main(String[] args) {
        Function<Integer, String> numberChecker = num -> {
            if (num > 0) return "Положительное число";
            else if (num < 0) return "Отрицательное число";
            else return "Ноль";
        };
        
        System.out.println("5: " + numberChecker.apply(5));
        System.out.println("-3: " + numberChecker.apply(-3));
        System.out.println("0: " + numberChecker.apply(0));
    }
}