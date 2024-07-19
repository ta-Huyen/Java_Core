package TeacherSalaryManagement;

import java.util.Scanner;

public class Main {
    private static final Teachers[] teacherList = new Teachers[1000];
    private static final Subjects[] subjectList = new Subjects[1000];
    private static final TeachingManagement[] teachingManagement = new TeachingManagement[1000];
    private static int teacherCount = 0;
    private static int subjectCount = 0;
    private static int teachingManagementCount = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu.");
            System.out.println("1: Nhap danh sach mon hoc moi.");
            System.out.println("2: Nhap danh sach giang vien moi.");
            System.out.println("3: Lap bang ke khai day hoc cho moi giang vien.");
            System.out.println("4: Sap xep danh sach ke khai giang day.");
            System.out.println("5: Lap bang tinh tien cong cho moi giang vien.");
            System.out.println("0: Thoat.");

            System.out.println("Nhap lua chon: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    addNewSubjects();
                    printSubjectList();
                    break;
                case 2:
                    addNewTeachers();
                    printTeacherList();
                    break;
                case 3:
                    createTeachingManagementList();
                    break;
                case 4:
                    sortTeachingList();
                    printTeachingManagementList();
                    break;
                case 5:
                    calculateSalary();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void addNewSubjects() {
        System.out.println("Nhap so luong mon hoc moi:");
        int quantity = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<quantity; i++) {
            System.out.println("Nhap thong tin mon hoc thu " + (i + 1) + ".");
            System.out.print("Ten mon hoc: ");
            String name = scanner.nextLine();
            System.out.print("Tong so tiet: ");
            int numberOfLesson = Integer.parseInt(scanner.nextLine());
            System.out.print("So tiet ly thuyet: ");
            int numberOfTheoryLesson = Integer.parseInt(scanner.nextLine());
            System.out.print("Muc kinh phi: ");
            int price = Integer.parseInt(scanner.nextLine());
            subjectList[subjectCount] = new Subjects(name, numberOfLesson, numberOfTheoryLesson, price);
            subjectCount += 1;
        }
    }

    private static void addNewTeachers(){
        System.out.println("Nhap so luong giang vien moi:");
        int quantity = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<quantity; i++) {
            System.out.println("Nhap thong tin giang vien thu " + (i + 1) + ".");
            System.out.print("Ho ten: ");
            String name = scanner.nextLine();
            System.out.print("Dia chi: ");
            String address = scanner.nextLine();
            System.out.print("SDT: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Trinh do (GS-TS, PGS-TS, Giang vien chinh, Thac sy): ");
            String level = scanner.nextLine();
            teacherList[teacherCount] = new Teachers(name, address, phoneNumber, level);
            teacherCount += 1;
        }
    }

    private static void createTeachingManagementList() {
        System.out.println("Nhap ma giang vien:");
        int id = Integer.parseInt(scanner.nextLine());
        Teachers user = null;
        for (int i=0; i<teacherCount; i++) {
            if (teacherList[i].getTeacherId() == id) {
                user = teacherList[i];
                break;
            }
        }
        if (user == null) {
            System.out.println("Khong tim thay giang vien!");
            return;
        }

        TeachingManagement management = new TeachingManagement(user);
        while (true) {
            System.out.println("Nhap ma mon hoc muon giang day (nhan 0 de ket thuc):");
            int subjId = Integer.parseInt(scanner.nextLine());
            if (subjId == 0) break;
            Subjects subj = null;
            for (int i=0; i<subjectCount; i++) {
                if (subjectList[i].getSubjectId() == subjId) {
                    subj = subjectList[i];
                    break;
                }
            }
            if (subj == null) {
                System.out.println("Khong tim thay mon hoc!");
                continue;
            }
            System.out.print("Nhap so luong lop muon day: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!management.teaching(subj, quantity)) {
                System.out.println("So luong lop da vuot qua 3, khong the dang ky them!");
            }
        }
        teachingManagement[teachingManagementCount] = management;
        teachingManagementCount += 1;

        printTeachingManagementList();
    }

    private static void sortTeachingList() {
        System.out.println("1: Sap xep theo ho ten giang vien.");
        System.out.println("2: Sap xep theo so tiet giang day moi mon (giam dan)");

        System.out.println("Nhap lua chon:");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            for (int i = 0; i< teachingManagementCount-1; i++) {
                for (int j = i+1; j< teachingManagementCount; j++) {
                    if (teachingManagement[i].getTeacher().getName().compareTo(teachingManagement[j].getTeacher().getName()) > 0) {
                        TeachingManagement temp = teachingManagement[i];
                        teachingManagement[i] = teachingManagement[j];
                        teachingManagement[j] = temp;
                    }
                }
            }
        } else if (choice == 2) {
            for (int i = 0; i < teachingManagementCount - 1; i++) {
                for (int j = i + 1; j < teachingManagementCount; j++) {
                    if (teachingManagement[i].getTotalClasses() < teachingManagement[j].getTotalClasses()) {
                        TeachingManagement temp = teachingManagement[i];
                        teachingManagement[i] = teachingManagement[j];
                        teachingManagement[j] = temp;
                    }
                }
            }
        } else {
            System.out.println("Lua chon khong hop le!");
        }
    }

    private static void calculateSalary() {
        System.out.println("Tien cong cho moi giang vien la:");
        for (int i = 0; i< teachingManagementCount; i++) {
            System.out.println(teachingManagement[i].getTeacher().getName() + " - " + teachingManagement[i].calculateSalaryPerTeacher());
        }
    }

    private static void printSubjectList() {
        System.out.println("Danh sach cac mon hoc:");
        for (int i = 0; i < subjectCount; i++) {
            System.out.println(subjectList[i].toString());
        }
    }

    private static void printTeacherList() {
        System.out.println("Danh sach cac giang vien:");
        for (int i=0; i < teacherCount; i++) {
            System.out.println(teacherList[i].toString());
        }
    }

    private static void printTeachingManagementList() {
        System.out.println("Bang ke khai day hoc:");
        for (int i = 0; i < teachingManagementCount; i++) {
            System.out.println(teachingManagement[i].toString());
        }
    }

}