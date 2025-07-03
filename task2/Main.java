package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarDealership dealership = new CarDealership();
        
        dealership.addCar(new Car("VIN1", "Model S", "Tesla", 2021, 25000, 80000, CarType.ELECTRIC));
        dealership.addCar(new Car("VIN2", "Camry", "Toyota", 2020, 45000, 25000, CarType.SEDAN));
        
        while (true) {
            System.out.println("\n1. Задание 1 (Массивы)");
            System.out.println("2. Задание 2 (Коллекции)");
            System.out.println("3. Задание 3 (Car)");
            System.out.println("4. Задание 4 (Stream API)");
            System.out.println("5. Работа с автоцентром");
            System.out.println("0. Выход");
            System.out.print("Выберите: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    CarTasks.task1();
                    break;
                case 2:
                    CarTasks.task2();
                    break;
                case 3:
                    CarTasks.task3();
                    break;
                case 4:
                    CarTasks.task4();
                    break;
                case 5:
                    dealershipMenu(dealership, scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
    
    private static void dealershipMenu(CarDealership dealership, Scanner scanner) {
        while (true) {
            System.out.println("\nАвтоцентр:");
            System.out.println("1. Добавить машину");
            System.out.println("2. Найти по производителю");
            System.out.println("3. Средняя цена по типу");
            System.out.println("4. Список по году выпуска");
            System.out.println("5. Статистика");
            System.out.println("0. Назад");
            System.out.print("Выберите: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addCarMenu(dealership, scanner);
                    break;
                case 2:
                    System.out.print("Производитель: ");
                    String maker = scanner.nextLine();
                    dealership.findByManufacturer(maker).forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Тип (SEDAN, SUV, ELECTRIC...): ");
                    try {
                        CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());
                        System.out.printf("Средняя цена: %.2f$\n", dealership.getAveragePriceByType(type));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неверный тип автомобиля!");
                    }
                    break;
                case 4:
                    dealership.getCarsSortedByYear().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Количество по типам:");
                    dealership.getTypeStatistics().forEach((type, count) -> 
                        System.out.println(type + ": " + count));
                    System.out.println(dealership.getOldestNewestInfo());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
    
    private static void addCarMenu(CarDealership dealership, Scanner scanner) {
        try {
            System.out.print("VIN: ");
            String vin = scanner.nextLine();
            System.out.print("Модель: ");
            String model = scanner.nextLine();
            System.out.print("Производитель: ");
            String manufacturer = scanner.nextLine();
            System.out.print("Год выпуска: ");
            int year = scanner.nextInt();
            System.out.print("Пробег (км): ");
            int mileage = scanner.nextInt();
            System.out.print("Цена: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Тип (SEDAN, SUV...): ");
            CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());
            
            Car car = new Car(vin, model, manufacturer, year, mileage, price, type);
            if (dealership.addCar(car)) {
                System.out.println("Машина добавлена!");
            } else {
                System.out.println("Ошибка: машина с таким VIN уже существует");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        }
    }
}