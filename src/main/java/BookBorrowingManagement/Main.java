package BookBorrowingManagement;

import java.util.Scanner;

public class Main {
    private static final Readers[] readers = new Readers[1000];
    private static final Books[] books = new Books[1000];
    private static final BookBorrowingManagement[] bookManagement = new BookBorrowingManagement[1000];
    private static int readerCount = 0;
    private static int bookCount = 0;
    private static int bookManegementCount = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu.");
            System.out.println("1: Nhap danh sach dau sach moi.");
            System.out.println("2: Nhap danh sach ban doc moi.");
            System.out.println("3: Lap bang quan ly muon sach.");
            System.out.println("4: Sap xep danh sach quan ly muon sach.");
            System.out.println("5: Tim kiem va hien thi danh sach muon sach theo ten nguoi doc.");
            System.out.println("0: Thoat.");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    addNewBooks();
                    printBooksList();
                    break;
                case 2:
                    addNewReaders();
                    printReadersList();
                    break;
                case 3:
                    createBookManagementTable();
                    break;
                case 4:
                    sortBooksList();
                    printBooksBorrowingList();
                    break;
                case 5:
                    searchByReaderName();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void addNewBooks() {
        System.out.println("Nhap so luong sach moi:");
        int newBoookQuantity = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<newBoookQuantity; i++) {
            System.out.println("Nhap thong tin sach thu " + (i + 1) + ".");
            System.out.print("Ten sach: ");
            String bookName = scanner.nextLine();
            System.out.print("Tac gia: ");
            String author = scanner.nextLine();
            System.out.print("Chuyen nganh: ");
            String speciality = scanner.nextLine();
            System.out.print("Nam xuat ban: ");
            int publishedYear = Integer.parseInt(scanner.nextLine());
            books[bookCount] = new Books(bookName, author, speciality, publishedYear);
            bookCount += 1;
        }
    }

    private static void addNewReaders(){
        System.out.println("Nhap so luong nguoi doc moi:");
        int newReaderQuantity = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<newReaderQuantity; i++) {
            System.out.println("Nhap thong tin nguoi doc thu " + (i + 1) + ".");
            System.out.print("Ho ten: ");
            String name = scanner.nextLine();
            System.out.print("Dia chi: ");
            String address = scanner.nextLine();
            System.out.print("SDT: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Loai ban doc(sinh vien, hoc vien cao hoc, giao vien): ");
            String role = scanner.nextLine();
            readers[readerCount] = new Readers(name, address, phoneNumber, role);
            readerCount += 1;
        }
    }

    private static void createBookManagementTable() {
        System.out.println("Nhap ma ban doc:");
        int id = Integer.parseInt(scanner.nextLine());
        Readers user = null;
        for (int i=0; i<readerCount; i++) {
            if (readers[i].getReaderId() == id) {
                user = readers[i];
                break;
            }
        }
        if (user == null) {
            System.out.println("Khong tim thay ban doc!");
            return;
        }

        BookBorrowingManagement management = new BookBorrowingManagement(user);
        while (true) {
            System.out.println("Nhap ma sach muon muon (nhan 0 de ket thuc):");
            int bookId = Integer.parseInt(scanner.nextLine());
            if (bookId == 0) break;
            Books book = null;
            for (int i=0; i<bookCount; i++) {
                if (books[i].getBookId() == bookId) {
                    book = books[i];
                    break;
                }
            }
            if (book == null) {
                System.out.println("Khong tim thay sach!");
                continue;
            }
            System.out.print("Nhap so luong muon: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!management.borrow(book, quantity)) {
                System.out.println("Khong the muon qua muc cho muon!");
            }
        }
        bookManagement[bookManegementCount] = management;
        bookManegementCount += 1;

        printBooksBorrowingList();
    }

    private static void sortBooksList() {
        System.out.println("1: Sap xep theo ten ban doc.");
        System.out.println("2: Sap xep theo so luong cuon sach duoc muon (giam dan)");
        System.out.println("Nhap lua chon:");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            for (int i = 0; i< bookManegementCount -1; i++) {
                for (int j = i+1; j< bookManegementCount; j++) {
                    if (bookManagement[i].getReader().getName().compareTo(bookManagement[j].getReader().getName()) > 0) {
                        BookBorrowingManagement temp = bookManagement[i];
                        bookManagement[i] = bookManagement[j];
                        bookManagement[j] = temp;
                    }
                }
            }
        } else if (choice == 2) {
            for (int i = 0; i < bookManegementCount - 1; i++) {
                for (int j = i + 1; j < bookManegementCount; j++) {
                    if (bookManagement[i].getTotalBorrowedBook() < bookManagement[j].getTotalBorrowedBook()) {
                        BookBorrowingManagement temp = bookManagement[i];
                        bookManagement[i] = bookManagement[j];
                        bookManagement[j] = temp;
                    }
                }
            }
        } else {
            System.out.println("Lua chon khong hop le!");
        }
    }

    private static void searchByReaderName() {
        System.out.println("Nhap ten ban doc can tim:");
        String readerName = scanner.nextLine();
        for (int i = 0; i< bookManegementCount; i++) {
            if (bookManagement[i].getReader().getName().equalsIgnoreCase(readerName)) {
                System.out.println(bookManagement[i]);
            }
        }
    }

    private static void printBooksList() {
        System.out.println("Danh cac dau sach:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].toString());
        }
    }

    private static void printReadersList() {
        System.out.println("Danh sach ban doc:");
        for (int i=0; i < readerCount; i++) {
            System.out.println(readers[i].toString());
        }
    }

    private static void printBooksBorrowingList() {
        System.out.println("Danh sach quan ly muon sach:");
        for (int i = 0; i < bookManegementCount; i++) {
            System.out.println(bookManagement[i].toString());
        }
    }

}