import java.util.Scanner;

public class Main {

    static Room[] roomList = {
        new Room(101, "Standard", 300000, true),
        new Room(102, "Superior", 500000, true),
        new Room(103, "Deluxe", 600000, true),
        new Room(104, "Suite", 700000, true)
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Rooms:");
        displayAvailableRooms();

        System.out.println("\n== Room Booking ==");
        System.out.print("How many rooms would you like to book (max 3)? ");
        int numberOfBookings = scanner.nextInt();

        if (numberOfBookings > 3 || numberOfBookings < 1) {
            System.out.println("Invalid number of rooms.");
            return;
        }

        Room[] bookedRooms = new Room[numberOfBookings];
        int[] nights = new int[numberOfBookings];

        
        if (numberOfBookings >= 1) {
            bookedRooms[0] = chooseRoom(scanner, 1);
            System.out.print("Number of nights: ");
            nights[0] = scanner.nextInt();
        }
        if (numberOfBookings >= 2) {
            bookedRooms[1] = chooseRoom(scanner, 2);
            System.out.print("Number of nights: ");
            nights[1] = scanner.nextInt();
        }
        if (numberOfBookings == 3) {
            bookedRooms[2] = chooseRoom(scanner, 3);
            System.out.print("Number of nights: ");
            nights[2] = scanner.nextInt();
        }

        printReceipt(bookedRooms, nights);
    }

    static void displayAvailableRooms() {
        if (roomList[0].isAvailable) showRoom(roomList[0]);
        if (roomList[1].isAvailable) showRoom(roomList[1]);
        if (roomList[2].isAvailable) showRoom(roomList[2]);
        if (roomList[3].isAvailable) showRoom(roomList[3]);
    }

    static void showRoom(Room room) {
        System.out.println("Room Number: " + room.roomNumber + ", Type: " + room.type + ", Price: Rp " + room.pricePerNight);
    }

    static Room chooseRoom(Scanner scanner, int order) {
        System.out.print("Enter room number for selection #" + order + ": ");
        int number = scanner.nextInt();
        if (roomList[0].roomNumber == number && roomList[0].isAvailable) return roomList[0];
        if (roomList[1].roomNumber == number && roomList[1].isAvailable) return roomList[1];
        if (roomList[2].roomNumber == number && roomList[2].isAvailable) return roomList[2];
        if (roomList[3].roomNumber == number && roomList[3].isAvailable) return roomList[3];

        System.out.println("Room not available!");
        System.exit(1);
        return null;
    }

    static void printReceipt(Room[] bookedRooms, int[] nights) {
        double subtotal = 0;
        double serviceFee = 0;

        System.out.println("\n===== RESERVATION RECEIPT =====");
        for (int i = 0; i < bookedRooms.length; i++) {
            double roomTotal = bookedRooms[i].pricePerNight * nights[i];
            serviceFee += 50000;
            subtotal += roomTotal;

            System.out.println("Room " + bookedRooms[i].roomNumber + " (" + bookedRooms[i].type + ")");
            System.out.println("Price per night: Rp " + bookedRooms[i].pricePerNight);
            System.out.println("Nights: " + nights[i]);
            System.out.println("Room Total: Rp " + roomTotal + "\n");
        }

        double tax = subtotal * 0.10;
double preDiscountTotal = subtotal + tax + serviceFee;

boolean hasDiscount = false;
boolean freeBreakfast = false;

if (preDiscountTotal > 500000) {
    hasDiscount = true;
    freeBreakfast = true;
} else if (preDiscountTotal > 300000) {
    freeBreakfast = true;
}

double total = preDiscountTotal;
if (hasDiscount) {
    total *= 0.85;
}

System.out.println("Subtotal: Rp " + subtotal);
System.out.println("Tax (10%): Rp " + tax);
System.out.println("Service Fee: Rp " + serviceFee);
System.out.println("Free Breakfast: " + (freeBreakfast ? "Yes" : "No"));
if (hasDiscount) System.out.println("15% discount applied.");
System.out.println("TOTAL PAYMENT: Rp " + total);
System.out.println("Thank you for your reservation!");
    }
}