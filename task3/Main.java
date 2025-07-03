package task3;

public class Main {
    public static void main(String[] args) {

        RoomService<StandardRoom> standardService = new BasicRoomServiceImpl<>();
        StandardRoom standardRoom = new StandardRoom(101);
        standardService.clean(standardRoom);
        standardService.reserve(standardRoom);
        try {
            standardService.reserve(standardRoom); 
        } catch (RoomAlreadyBookedException e) {
            System.out.println("Error: " + e.getMessage());
        }
        standardService.free(standardRoom);


        LuxRoomService<LuxRoom> luxService = new LuxRoomServiceImpl<>();
        LuxRoom luxRoom = new LuxRoom(201);
        luxService.clean(luxRoom);
        luxService.reserve(luxRoom);
        luxService.foodDelivery(luxRoom, "Steak and wine");

    }
}