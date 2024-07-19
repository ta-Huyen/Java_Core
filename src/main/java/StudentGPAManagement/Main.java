package StudentGPAManagement;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Students[] studentList = new Students[1000];
    private static final Subjects[] subjectList = new Subjects[1000];
    private static final Reports[] reportList = new Reports[1000];
    private static int studentCount = 0;
    private static int subjectCount = 0;
    private static int reportCount = 0;

    private static final String STUDENTS_FILE = "src/main/java/StudentGPAManagement/data/sinhvien.txt";
    private static final String SUBJECTS_FILE = "src/main/java/StudentGPAManagement/data/monhoc.txt";
    private static final String REPORTS_FILE = "src/main/java/StudentGPAManagement/data/bangdiem.txt";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();

        while (true) {
            System.out.println("Menu.");
            System.out.println("1: Nhap danh sach sinh vien moi.");
            System.out.println("2: Nhap danh sach mon hoc moi.");
            System.out.println("3: Nhap diem cho sinh vien.");
            System.out.println("4: Sap xep danh sach bang diem.");
            System.out.println("5: Tinh diem tong ket chung cho sinh vien.");
            System.out.println("0: Thoat.");

            System.out.println("Nhap lua chon: ");
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1:
                        addNewStudents();
                        printStudentList();
                        break;
                    case 2:
                        addNewSubjects();
                        printSubjectList();
                        break;
                    case 3:
                        inputStudentGrade();
                        break;
                    case 4:
                        sortStudentReportList();
                        printStudentReportList();
                        break;
                    case 5:
                        calculateGPA();
                        break;
                    case 0:
                        saveData();
                        return;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void loadData() {
        try (BufferedReader studentReader = new BufferedReader(new FileReader(STUDENTS_FILE));
             BufferedReader subjectReader = new BufferedReader(new FileReader(SUBJECTS_FILE));
             BufferedReader reportReader = new BufferedReader(new FileReader(REPORTS_FILE)))
        {
            String line;
            while ((line = studentReader.readLine()) != null) {
                String[] parts = line.split(" - ");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String address = parts[2];
                String phone = parts[3];
                String classroom = parts[4];
                Students student = new Students(id, name, address, phone, classroom);
                studentList[studentCount] = student;
                studentCount += 1;
            }

            while ((line = subjectReader.readLine()) != null) {
                String[] parts = line.split(" - ");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int curriculum = Integer.parseInt(parts[2]);
                String type = parts[3];
                Subjects subject = new Subjects(id, name, curriculum, type);
                subjectList[subjectCount] = subject;
                subjectCount += 1;
            }

            while ((line = reportReader.readLine()) != null) {
                String[] parts = line.split(" - ");
                int studentId = Integer.parseInt(parts[0]);
                int subjectId = Integer.parseInt(parts[1]);
                double grade = Double.parseDouble(parts[2]);
                Students student = null;
                Subjects subject = null;

                for (int i=0; i<studentCount; i++) {
                    if (studentList[i].getStudentId() == studentId) {
                        student = studentList[i];
                        break;
                    }
                }

                for (int i = 0; i < subjectCount; i++) {
                    if (subjectList[i].getSubjectId() == subjectId) {
                        subject = subjectList[i];
                        break;
                    }
                }

                if (student != null && subject != null) {
                    reportList[reportCount] = new Reports(student, subject, grade);
                    reportCount += 1;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi khi doc du lieu: " + e.getMessage());
        }
    }

    private static void saveData() {
        try (BufferedWriter studentWriter = new BufferedWriter(new FileWriter(STUDENTS_FILE));
             BufferedWriter subjectWriter = new BufferedWriter(new FileWriter(SUBJECTS_FILE));
             BufferedWriter reportWriter = new BufferedWriter(new FileWriter(REPORTS_FILE)))
        {
            for (int i=0; i<studentCount; i++) {
                studentWriter.write(studentList[i].toString());
                studentWriter.newLine();
            }

            for (int i=0; i<subjectCount; i++) {
                subjectWriter.write(subjectList[i].saveData());
                subjectWriter.newLine();
            }

            for (int i=0; i<reportCount; i++) {
                reportWriter.write(reportList[i].saveData());
                reportWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Loi khi luu du lieu: " + e.getMessage());
        }
    }

    private static void addNewSubjects() {
        System.out.println("Nhap so luong mon hoc moi:");
        int quantity = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<quantity; i++) {
            System.out.println("Nhap thong tin mon hoc thu " + (i + 1) + ".");
            System.out.print("Ten mon hoc: ");
            String name = scanner.nextLine();
            System.out.print("So don vi hoc trinh: ");
            int curriculum = Integer.parseInt(scanner.nextLine());
            System.out.print("Loai mon(Dai cuong, Co so nganh, Chuyen nganh): ");
            String type = scanner.nextLine();
            subjectList[subjectCount] = new Subjects(0, name, curriculum, type);
            subjectCount += 1;
        }
    }

    private static void addNewStudents(){
        System.out.println("Nhap so luong sinh vien moi:");
        int quantity = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<quantity; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ".");
            System.out.print("Ho ten: ");
            String name = scanner.nextLine();
            System.out.print("Dia chi: ");
            String address = scanner.nextLine();
            System.out.print("SDT: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Lop: ");
            String classroom = scanner.nextLine();
            studentList[studentCount] = new Students(0, name, address, phoneNumber, classroom);
            studentCount += 1;
        }
    }

    private static void inputStudentGrade() {
        System.out.println("Nhap ma sinh vien:");
        int id = Integer.parseInt(scanner.nextLine());
        Students user = null;
        for (int i=0; i<studentCount; i++) {
            if (studentList[i].getStudentId() == id) {
                user = studentList[i];
                break;
            }
        }
        if (user == null) {
            System.out.println("Khong tim thay sinh vien!");
            return;
        }

        while (true) {
            System.out.println("Nhap ma mon hoc muon nhap diem (nhan 0 de ket thuc):");
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
            System.out.print("Nhap diem mon hoc: ");
            double grade = Double.parseDouble(scanner.nextLine());
            if ((grade < 0) || (grade > 10)) {
                System.out.println("Diem khong hop le!");
                continue;
            }

            reportList[reportCount] = new Reports(user, subj, grade) ;
            reportCount += 1;

        }

        printStudentReportList();
    }

    private static void sortStudentReportList() {
        System.out.println("1: Sap xep theo ho ten sinh vien.");
        System.out.println("2: Sap xep theo ten mon hoc");

        System.out.println("Nhap lua chon:");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            for (int i=0; i<reportCount-1; i++) {
                for (int j=i+1; j<reportCount; j++) {
                    if (reportList[i].getStudent().getName().compareTo(reportList[j].getStudent().getName()) > 0) {
                        Reports temp = reportList[i];
                        reportList[i] = reportList[j];
                        reportList[j] = temp;
                    }
                }
            }
        } else if (choice == 2) {
            for (int i=0; i<reportCount - 1; i++) {
                for (int j=i+1; j<reportCount; j++) {
                    if (reportList[i].getSubject().getName().compareTo(reportList[j].getSubject().getName()) > 0) {
                        Reports temp = reportList[i];
                        reportList[i] = reportList[j];
                        reportList[j] = temp;
                    }
                }
            }
        } else {
            System.out.println("Lua chon khong hop le!");
        }
    }

    private static void calculateGPA() {
        System.out.println("Diem tong ket chung cua sinh vien la:");
        for (int i=0; i<studentCount; i++) {
            double sumGrade = 0;
            int sumCurriculum = 0;
            for (int j = 0; j< reportCount; j++) {
                if (reportList[j].getStudent().getStudentId() == studentList[i].getStudentId()) {
                    sumGrade += reportList[j].getSubject().getCurriculum()*reportList[j].getGrade();
                    sumCurriculum += reportList[j].getSubject().getCurriculum();
                }
            }
            if (sumCurriculum != 0) {
                System.out.println(studentList[i].getName() + " - Diem tong ket: " + sumGrade/sumCurriculum);
            }
        }

    }

    private static void printStudentList() {
        System.out.println("Danh sach cac sinh vien:");
        for (int i=0; i < studentCount; i++) {
            System.out.println(studentList[i].toString());
        }
    }

    private static void printSubjectList() {
        System.out.println("Danh sach cac mon hoc:");
        for (int i = 0; i < subjectCount; i++) {
            System.out.println(subjectList[i].toString());
        }
    }

    private static void printStudentReportList() {
        System.out.println("Bang ke khai day hoc:");
        for (int i = 0; i < reportCount; i++) {
            System.out.println(reportList[i].toString());
        }
    }

}