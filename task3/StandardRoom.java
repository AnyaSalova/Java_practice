package task3;

public class StandardRoom extends Room {
    public StandardRoom(int roomNumber) {
        super(roomNumber, (int)(Math.random() * 3) + 1, Prices.STANDARD.getPrice());
    }
}