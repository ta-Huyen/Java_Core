package StudentGPAManagement;

public class Students {
    private static int currentId = 10000;
    private final int studentId;
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final String classroom;

    public Students(int id, String name, String address, String phoneNumber, String classroom) {
        this.studentId = (id == 0) ? currentId : id;
        currentId = this.studentId + 1;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
    }

    public int getStudentId() {
        return studentId;
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

    public String getClassroom() {
        return classroom;
    }

    @Override
    public String toString() {
        return studentId + " - " + name + " - " + address + " - " + phoneNumber + " - " + classroom;
    }
}
