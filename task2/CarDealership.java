package task2;

import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private List<Car> cars = new ArrayList<>();

    public boolean addCar(Car car) {
        if (cars.stream().anyMatch(c -> c.getVin().equals(car.getVin()))) {
            return false;
        }
        cars.add(car);
        return true;
    }

    public List<Car> findByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(c -> c.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public double getAveragePriceByType(CarType type) {
        return cars.stream()
                .filter(c -> c.getType() == type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
    }

    public List<Car> getCarsSortedByYear() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getYear).reversed())
                .collect(Collectors.toList());
    }

    public Map<CarType, Long> getTypeStatistics() {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
    }

    public String getOldestNewestInfo() {
        Optional<Car> oldest = cars.stream().min(Comparator.comparingInt(Car::getYear));
        Optional<Car> newest = cars.stream().max(Comparator.comparingInt(Car::getYear));
        
        return String.format("Самая старая: %d год, самая новая: %d год",
                oldest.map(Car::getYear).orElse(0),
                newest.map(Car::getYear).orElse(0));
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }
}