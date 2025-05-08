public class Room {
    int roomNumber;
    String type;
    double pricePerNight;
    boolean isAvailable;

    public Room(int roomNumber, String type, double pricePerNight, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }
}
