//Identify base classes
class Hotel {
    String name;
    Integer id;
    Location hotelLocattion;
    List<Room> roomList;
}

class Location {
    Integer pin;
    String street;
    String area;
    String city;
    String country;
}

class Room {
    String roomNumber;
    RoomStyle roomStyle;
    RoomStatus roomStatus;
    List<RoomKey> roomKeys;
    Double bookingPrice;
    List<HouseKeepingLog> houseKeepingLog;
}

public enum RoomStyle {
    STANDARD, DELUXE, FAMILY_SUITE;
}

public enum RoomStatus {
    AVAILABLE, RESERVED, NOT_AVAILABLE, OCCUPIED, SERVICE_IN_PROGRESS;
}

public class RoomKey {
    String keyId;
    String barCode;
    Date issuedAtDate;
    Boolean isActive;
    Booolean isMaster;

    public void assignRoom(Room room) {};
}

class HouseKeepingLog {
    String description;
    Date startDate;
    int duration;
    HouseKeeper housekeeper;
}

abstract class Person {
    String name;
    Account accountDetail;
    Strign phone;
}

public class Account {
    String username;
    String password;
    AccountStatus accountStatus;
}

public enum AccountStatus {
    ACTIVE, CLOSED, BLOCKED;
}

class HouseKeeper extends Person {
    public List<Room> public getRoomsServiced(Date data); 
}

class Guest extends Person {
    Search searchObj;
    Booking boookingObj;

    public List<RoomBooking> getAllRoomBookings();
}

class Receprionist extends Person {
    Search searchObj;
    Booking boookingObj;

    public void checkInguest(Room room, Guest guest);
    public void checkOutguest(Room room, Guest guest);
}

class Admin extends Person {
    public void addRoom(Room roomDetail);
    public void RemoveRoom(Room roomDetail);
    public void editRoom(Room roomDetail);
}

class Search {
    public List<Room> searchRoom(RomStyle roomStyle, Date startDate, int duration);
}

class Booking {
    public RoomBooking createBooking(Guest guestInfo);
    public RoomBooking cancelBooking(Guest guestInfo);

}

class RoomBooking {
    String bookingId;
    Date startDate;
    Int durationDays;
    BookingStatus bookingStatus;
    List<Guest> guestList;
    List<Room> roomInfo;
    BaseRoomCharge totalRoomCharges;
}

interface BaseRoomCharge {
    double getCost;
}

class RoomCharge implements BaseRoomCharge {
    double cost;
    Double getCost()  {
        return cost;
    }
    Double setCost()  {
        this.cost = cost;
    }
}

class RoomServiceCharge implements BaseRoomCharge {
    double cost;
    BaseRoomCharge baseRoomCharge;
    Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost + cost);
        return baseRoomCharge.cost();
    }
}

class InRoomPurchaseCharge implements BaseRoomCharge {
    double cost;
    BaseRoomCharge baseRoomCharge;
    Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost + cost);
        return baseRoomCharge.cost();
    }
}