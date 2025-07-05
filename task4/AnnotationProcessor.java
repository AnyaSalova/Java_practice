package task4;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<?> clazz = OldClass.class;
        
        // Проверка класса
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.printf("Внимание: класс '%s' устарел. Альтернатива: '%s'%n",
                clazz.getSimpleName(), annotation.message());
        }
        
        // Проверка методов
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.printf("Внимание: метод '%s' устарел. Альтернатива: '%s'%n",
                    method.getName(), annotation.message());
            }
        }
    }
}