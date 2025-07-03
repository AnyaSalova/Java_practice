package task2;

import java.util.*;
import java.util.stream.Collectors;

public class CarTasks {
    public static void task1() {
        int[] carYears = new int[50];
        Random random = new Random();
        
        for (int i = 0; i < carYears.length; i++) {
            carYears[i] = 2000 + random.nextInt(26);
        }
        
        System.out.println("Машины после 2015 года:");
        Arrays.stream(carYears)
              .filter(year -> year > 2015)
              .forEach(System.out::println);
        
        double averageYear = Arrays.stream(carYears).average().orElse(0);
        System.out.printf("\nСредний год выпуска: %.1f\n", averageYear);
    }

    // Задание 2: Работа с коллекциями
    public static void task2() {
        List<String> models = Arrays.asList(
            "Toyota Camry", "BMW X5", "Tesla Model S",
            "Audi A6", "Tesla Model 3", "BMW X5"
        );
        
        // Удаление дубликатов и сортировка
        List<String> uniqueModels = models.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        
        System.out.println("Уникальные модели:");
        uniqueModels.forEach(System.out::println);
        
        // Замена Tesla
        uniqueModels.replaceAll(s -> s.contains("Tesla") ? "ELECTRO_CAR" : s);
        
        // Сохранение в TreeSet
        Set<String> modelSet = new TreeSet<>(uniqueModels);
        System.out.println("\nРезультат в TreeSet:");
        modelSet.forEach(System.out::println);
    }

    // Задание 3: Демонстрация работы Car
    public static void task3() {
        Set<Car> carSet = new HashSet<>();
        carSet.add(new Car("VIN001", "Camry", "Toyota", 2020, 50000, 25000, CarType.SEDAN));
        carSet.add(new Car("VIN002", "X5", "BMW", 2022, 30000, 60000, CarType.SUV));
        carSet.add(new Car("VIN001", "Corolla", "Toyota", 2018, 80000, 15000, CarType.SEDAN));
        
        System.out.println("Машины в HashSet:");
        carSet.forEach(System.out::println);
    }

    // Задание 4: Stream API
    public static void task4() {
        List<Car> cars = Arrays.asList(
            new Car("VIN1", "Model S", "Tesla", 2021, 25000, 80000, CarType.ELECTRIC),
            new Car("VIN2", "Camry", "Toyota", 2020, 45000, 25000, CarType.SEDAN),
            new Car("VIN3", "X5", "BMW", 2022, 40000, 70000, CarType.SUV)
        );
        
        System.out.println("Машины с пробегом < 50000 км:");
        cars.stream()
            .filter(c -> c.getMileage() < 50000)
            .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
            .forEach(System.out::println);
        
        System.out.println("\nТоп-3 самые дорогие:");
        cars.stream()
            .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
            .limit(3)
            .forEach(System.out::println);
        
        double avgMileage = cars.stream()
            .mapToInt(Car::getMileage)
            .average()
            .orElse(0);
        System.out.printf("\nСредний пробег: %.1f км\n", avgMileage);
    }
}