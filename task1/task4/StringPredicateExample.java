package task4;

import java.util.function.Predicate;

public class StringPredicateExample {
    public static void main(String[] args) {
        Predicate<String> startsWithJorN = s -> s != null && (s.startsWith("J") || s.startsWith("N"));
        Predicate<String> endsWithA = s -> s != null && s.endsWith("A");
        
        Predicate<String> combined = startsWithJorN.and(endsWithA);
        
        System.out.println("JavaA: " + combined.test("JavaA"));
        System.out.println("NovaA: " + combined.test("NovaA"));
        System.out.println("PythonA: " + combined.test("PythonA"));
        System.out.println("JavaB: " + combined.test("JavaB"));
        System.out.println("null: " + combined.test(null));
    }
}