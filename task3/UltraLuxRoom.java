package task3;

public class UltraLuxRoom extends ProRoom {
    public UltraLuxRoom(int roomNumber) {
        super(roomNumber, (int)(Math.random() * 2) + 2, Prices.ULTRA_LUX.getPrice());
    }
}