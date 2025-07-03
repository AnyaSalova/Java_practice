package task3;

public class Main {
    public static void main(String[] args) {
        // Тестирование базового сервиса
        RoomService<StandardRoom> standardService = new BasicRoomServiceImpl<>();
        StandardRoom standardRoom = new StandardRoom(101);
        standardService.clean(standardRoom);
        standardService.reserve(standardRoom);
        try {
            standardService.reserve(standardRoom); // Должно выбросить исключение
        } catch (RoomAlreadyBookedException e) {
            System.out.println("Error: " + e.getMessage());
        }
        standardService.free(standardRoom);

        // Тестирование люксового сервиса
        LuxRoomService<LuxRoom> luxService = new LuxRoomServiceImpl<>();
        LuxRoom luxRoom = new LuxRoom(201);
        luxService.clean(luxRoom);
        luxService.reserve(luxRoom);
        luxService.foodDelivery(luxRoom, "Steak and wine");

        // Проверка, что нельзя создать Room или ProRoom напрямую
        // Room room = new Room(1, 2, 1000); // Ошибка компиляции - Room абстрактный
        // ProRoom proRoom = new ProRoom(2, 3, 2000); // Ошибка компиляции - ProRoom абстрактный
    }
}