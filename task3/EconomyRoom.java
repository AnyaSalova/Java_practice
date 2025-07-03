package task3;

public class EconomyRoom extends Room {
    public EconomyRoom(int roomNumber) {
        super(roomNumber, (int)(Math.random() * 2) + 1, Prices.ECONOMY.getPrice());
    }
}