package TeacherSalaryManagement;

public class Teachers {
    private static int currentId = 100;
    private final int teacherId;
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final String level;

    public Teachers(String name, String address, String phoneNumber, String level) {
        this.teacherId = currentId++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.level = level;
    }

    public int getTeacherId() {
        return teacherId;
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

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Ma giang vien: " + teacherId +
                " - Ho ten: " + name +
                " - Dia chi: " + address +
                " - SDT: " + phoneNumber +
                " - Trinh do: " + level;
    }
}
