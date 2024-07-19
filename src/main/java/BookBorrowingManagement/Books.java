package BookBorrowingManagement;

public class Books {
    private static int currentId = 10000;
    private final int bookId;
    private final String title;
    private final String author;
    private final String speciality;
    private final int publishedYear;

    public Books(String title, String author, String speciality, int publishedYear) {
        this.bookId = currentId++;
        this.title = title;
        this.author = author;
        this.speciality = speciality;
        this.publishedYear = publishedYear;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSpeciality() {
        return speciality;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    @Override
    public String toString() {
        return "Ma sach: " + bookId +
                ", Ten sach: " + title +
                ", Tac gia: " + author +
                ", Chuyen nganh: " + speciality +
                ", Nam xuat ban: " + publishedYear;
    }

}
