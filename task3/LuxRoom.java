package task3;

public class LuxRoom extends ProRoom {
    public LuxRoom(int roomNumber) {
        super(roomNumber, (int)(Math.random() * 2) + 2, Prices.LUX.getPrice());
    }
}