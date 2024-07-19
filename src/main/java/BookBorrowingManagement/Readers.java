package BookBorrowingManagement;

public class Readers {
    private static int currentId = 10000;
    private final int readerId;
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final String role;

    public Readers(String name, String address, String phoneNumber, String role) {
        this.readerId = currentId++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }


    public int getReaderId() {
        return readerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Ma nguoi doc: " + readerId +
                ", Ho ten: " + name +
                ", Dia chi: " + address +
                ", SDT: " + phoneNumber +
                ", Loai ban doc: " + role;
    }

}
