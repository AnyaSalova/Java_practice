package task4;

import java.util.function.Predicate;

public class StringCheckExample {
    public static void main(String[] args) {

        Predicate<String> isNotNull = s -> s != null;
        System.out.println("Is 'hello' not null? " + isNotNull.test("hello"));
        System.out.println("Is null not null? " + isNotNull.test(null));

        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        System.out.println("Is 'hello' not empty? " + isNotEmpty.test("hello"));
        System.out.println("Is '' not empty? " + isNotEmpty.test(""));

        Predicate<String> isValid = isNotNull.and(isNotEmpty);
        System.out.println("Is 'hello' valid? " + isValid.test("hello"));
        System.out.println("Is '' valid? " + isValid.test(""));
        System.out.println("Is null valid? " + isValid.test(null));
    }
}
