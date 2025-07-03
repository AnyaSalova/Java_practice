package task3;

public class BasicRoomServiceImpl<T extends Room> implements RoomService<T> {
    @Override
    public void clean(T room) {
        System.out.println("Уборка номера " + room.getRoomNumber() + " завершена");
    }

    @Override
    public void reserve(T room) {
        if (room.isBooked()) {
            throw new RoomAlreadyBookedException("Номер " + room.getRoomNumber() + " уже забронирован");
        }
        room.setBooked(true);
        System.out.println("Номер " + room.getRoomNumber() + " успешно забронирован");
    }

    @Override
    public void free(T room) {
        room.setBooked(false);
        System.out.println("Номер " + room.getRoomNumber() + " освобожден");
    }
}