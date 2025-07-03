package task3;

public interface LuxRoomService<T extends ProRoom> extends RoomService<T> {
    void foodDelivery(T room, String order);
}