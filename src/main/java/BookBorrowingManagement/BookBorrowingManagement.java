package BookBorrowingManagement;

public class BookBorrowingManagement {
    private final Readers reader;
    private final Books[] borrowedBook;
    private final int[] borrowedQuantity;
    private int titleQuantity;

    public BookBorrowingManagement(Readers reader) {
        this.reader = reader;
        this.borrowedBook = new Books[5];
        this.borrowedQuantity = new int[5];
        this.titleQuantity = 0;
    }

    public int getTotalBorrowedBook() {
        int total = 0;
        for (int i=0; i<titleQuantity; i++) {
            total += borrowedQuantity[i];
        }
        return total;
    }

    public boolean borrow(Books book, int quantity) {
        if ((titleQuantity > 5) || (quantity > 3)) return false;
        for (int i = 0; i < titleQuantity; i++) {
            if (this.borrowedBook[i].getBookId() == book.getBookId()) {
                if ((this.borrowedQuantity[i]+quantity) > 3) {
                    return false;
                } else {
                    this.borrowedQuantity[i] += quantity;
                    return true;
                }
            }
        }
        this.borrowedBook[titleQuantity] = book;
        this.borrowedQuantity[titleQuantity] = quantity;
        titleQuantity += 1;
        return true;
    }

    public Readers getReader() {
        return reader;
    }

    public Books[] getBorrowingBook() {
        return borrowedBook;
    }

    public int[] getBorrowedQuantity() {
        return borrowedQuantity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Danh sach muon sach cua " + reader.getName() + ":");
        for (int i = 0; i < titleQuantity; i++) {
            result.append("\n\t" + borrowedBook[i].getTitle() + " - " + borrowedQuantity[i] + " cuon");
        }
        return result.toString();
    }
}
