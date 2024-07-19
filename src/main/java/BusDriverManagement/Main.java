package BusDriverManagement;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final ArrayList<BusDriver> drivers = new ArrayList<>();
    private static final ArrayList<BusLines> lines = new ArrayList<>();
    private static final ArrayList<AssignmentBoard> assignments = new ArrayList<>();

    private static final String BUS_DRIVERS_FILE = "src/main/java/BusDriverManagement/data/laixe.txt";
    private static final String BUS_LINES_FILE = "src/main/java/BusDriverManagement/data/tuyenxe.txt";
    private static final String ASSIGNMENT_FILE = "src/main/java/BusDriverManagement/data/bangphancong.txt";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();

        while (true) {
            System.out.println("Menu.");
            System.out.println("1: Nhap danh sach lai xe moi.");
            System.out.println("2: Nhap danh sach tuyen moi.");
            System.out.println("3: Nhap phan cong cho moi lai xe.");
            System.out.println("4: Sap xep danh sach phan cong.");
            System.out.println("5: Lap bang thong ke tong khoang cach xe chay trong ngay.");
            System.out.println("0: Thoat.");

            System.out.println("Nhap lua chon: ");
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1:
                        addNewDrivers();
                        printDriverList();
                        break;
                    case 2:
                        addNewLines();
                        printLineList();
                        break;
                    case 3:
                        inputAssignmentBoard();
                        break;
                    case 4:
                        sortAssignmentBoard();
                        printAssignmentBoard();
                        break;
                    case 5:
                        calculateDistance();
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
        try (BufferedReader driverReader = new BufferedReader(new FileReader(BUS_DRIVERS_FILE));
             BufferedReader linesReader = new BufferedReader(new FileReader(BUS_LINES_FILE));
             BufferedReader assignmentReader = new BufferedReader(new FileReader(ASSIGNMENT_FILE)))
        {
            String line;
            while ((line = driverReader.readLine()) != null) {
                String[] parts = line.split(" - ");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String address = parts[2];
                String phoneNumber = parts[3];
                String level = parts[4];

                drivers.add(new BusDriver(id, name, address, phoneNumber, level));
            }

            while ((line = linesReader.readLine()) != null) {
                String[] parts = line.split(" - ");
                int id = Integer.parseInt(parts[0]);
                double distance = Double.parseDouble(parts[1]);
                int busStop = Integer.parseInt(parts[2]);

                lines.add(new BusLines(id, distance, busStop));
            }

            while ((line = assignmentReader.readLine()) != null) {
                String[] parts = line.split(" - ");
                int driverId = Integer.parseInt(parts[0]);
                int lineId = Integer.parseInt(parts[1]);
                int turns = Integer.parseInt(parts[2]);

                List<BusDriver> filterDriver = drivers.stream().filter(d -> (d.getLxId() == driverId)).toList();
                List<BusLines> filterLine = lines.stream().filter(l -> (l.getLineId() == lineId)).toList();

                if (!filterDriver.isEmpty() && !filterLine.isEmpty()) {
                    assignments.add(new AssignmentBoard(filterDriver.get(0), filterLine.get(0), turns));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi khi doc du lieu: " + e.getMessage());
        }
    }

    private static void saveData() {
        try (BufferedWriter driverWriter = new BufferedWriter(new FileWriter(BUS_DRIVERS_FILE));
             BufferedWriter linesWriter = new BufferedWriter(new FileWriter(BUS_LINES_FILE));
             BufferedWriter assignmentWriter = new BufferedWriter(new FileWriter(ASSIGNMENT_FILE)))
        {
            for (BusDriver i : drivers) {
                driverWriter.write(i.toString());
                driverWriter.newLine();
            }

            for (BusLines i : lines) {
                linesWriter.write(i.saveData());
                linesWriter.newLine();
            }

            for (AssignmentBoard i : assignments) {
                assignmentWriter.write(i.saveData());
                assignmentWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Loi khi luu du lieu: " + e.getMessage());
        }
    }

    private static void addNewDrivers(){
        System.out.println("Nhap so luong lai xe moi:");
        int quantity = Integer.parseInt(scanner.nextLine());

        for (int i=0; i<quantity; i++) {
            System.out.println("Nhap thong tin lai xe thu " + (i + 1) + ".");
            System.out.print("Ho ten: ");
            String name = scanner.nextLine();
            System.out.print("Dia chi: ");
            String address = scanner.nextLine();
            System.out.print("SDT: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Trinh do (A->F): ");
            String level = scanner.nextLine();

            drivers.add(new BusDriver(0, name, address, phoneNumber, level));
        }
    }

    private static void addNewLines() {
        System.out.println("Nhap so luong tuyen xe moi:");
        int quantity = Integer.parseInt(scanner.nextLine());

        for (int i=0; i<quantity; i++) {
            System.out.println("Nhap thong tin tuyen xe thu " + (i + 1) + ".");
            System.out.print("Khoang cach: ");
            double distance = Double.parseDouble(scanner.nextLine());
            System.out.print("So diem dung: ");
            int busStop = Integer.parseInt(scanner.nextLine());

            lines.add(new BusLines(0, distance, busStop));
        }
    }

    private static void inputAssignmentBoard() {
        System.out.println("Nhap ma lai xe:");
        int id = Integer.parseInt(scanner.nextLine());

        List<BusDriver> filterDriver = drivers.stream().filter(d -> (d.getLxId() == id)).toList();

        if (filterDriver.isEmpty()) {
            System.out.println("Khong tim thay lai xe!");
            return;
        }

        while (true) {
            System.out.println("Nhap tuyen xe phan cong cho lai xe(nhan 0 de ket thuc):");
            int lineId = Integer.parseInt(scanner.nextLine());
            if (lineId == 0) break;

            List<BusLines> filterLines = lines.stream().filter(line -> (line.getLineId() == lineId)).toList();
            if (filterLines.isEmpty()) {
                System.out.println("Khong tim thay tuyen xe!");
                continue;
            }

            System.out.print("Nhap so luot lai trong ngay: ");
            int n = Integer.parseInt(scanner.nextLine());

            if (!checkAllowedTurn(filterDriver.get(0), filterLines.get(0), n)) {
                System.out.println("So luong luot lai trong ngay da vuot qua 15, khong the phan cong them!");
            }
        }

        printAssignmentBoard();
    }

    private static boolean checkAllowedTurn(BusDriver driver, BusLines line, int n) {
        if (n > 15) {
            return false;
        }

        List<AssignmentBoard> filterAssignment =
                assignments.stream().filter(a -> (a.getDriver().equals(driver))).toList();

        if (!filterAssignment.isEmpty()) {
            if ((filterAssignment.get(0).getTurns() + n) > 15) {
                return false;
            }
            filterAssignment.get(0).setTurns(n);
            return true;
        }

        assignments.add(new AssignmentBoard(driver, line, n));

        return true;
    }

    private static void sortAssignmentBoard() {
        System.out.println("1: Sap xep theo ho ten lai xe.");
        System.out.println("2: Sap xep theo so luong tuyen dam nhan trong ngay(giam dan)");

        System.out.println("Nhap lua chon:");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            Comparator<AssignmentBoard> compareByName = Comparator.comparing(a -> a.getDriver().getName());
            assignments.sort(compareByName);
        } else if (choice == 2) {
            ArrayList<List<AssignmentBoard>> mapAssignmentByDriver = new ArrayList<>();
            for (BusDriver driver : drivers) {
                List<AssignmentBoard> filterAssignment = assignments.stream().filter(a -> (a.getDriver().equals(driver))).collect(Collectors.toList());

                if (!filterAssignment.isEmpty()) {
                    mapAssignmentByDriver.add(filterAssignment);
                }
            }

            Comparator<List<AssignmentBoard>> compareByLines = (a1, a2) -> Integer.compare(a2.size(), a1.size());
            mapAssignmentByDriver.sort(compareByLines);

            assignments.clear();
            for (List<AssignmentBoard> i : mapAssignmentByDriver) {
                assignments.addAll(i);
            }
        } else {
            System.out.println("Lua chon khong hop le!");
        }
    }

    private static void calculateDistance() {
        System.out.println("Tong khoang cach xe chay cua moi lai xe:");
        for (AssignmentBoard i : assignments) {
            System.out.println("Lai xe " + i.getDriver().getName() + " lai " + i.getDrivingDistance() + "km");
        }
    }

    private static void printDriverList() {
        System.out.println("Danh sach cac lai xe:");
        for (BusDriver i : drivers) {
            System.out.println(i.toString());
        }
    }

    private static void printLineList() {
        System.out.println("Danh sach cac tuyen xe:");
        for (BusLines i : lines) {
            System.out.println(i.toString());
        }
    }

    private static void printAssignmentBoard() {
        System.out.println("Bang phan cong:");
        for (AssignmentBoard i : assignments) {
            System.out.println(i.toString());
        }
    }

}