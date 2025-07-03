package task3;

public class LuxRoomServiceImpl<T extends ProRoom> implements LuxRoomService<T> {
    private final BasicRoomServiceImpl<T> basicService = new BasicRoomServiceImpl<>();

    @Override
    public void clean(T room) {
        basicService.clean(room);
    }

    @Override
    public void reserve(T room) {
        basicService.reserve(room);
    }

    @Override
    public void free(T room) {
        basicService.free(room);
    }

    @Override
    public void foodDelivery(T room, String order) {
        System.out.println("Доставка еды в номер " + room.getRoomNumber() + ": " + order);
    }
}