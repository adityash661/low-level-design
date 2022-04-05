class Library {
    String name;
    Address location;
    List<BookItem> books;

}

class Address {
    int pincode;
    String street;
    String city;
    String state;
    String country;
}

class Book {
    int bookId;
    String title;
    String author;
    BookType bookType;
}

class BookItem extends Book {

    String barcode;
    Date publicationDate;
    Rack rackLocation;
    BookStatus bookStatus;
    BookFormat bookformat;
    Date issueDate;
}

public enum BookType {
    SCI_FI, FICTION
}

public enum BookStatus {
    ISSUED, AVAILABLE, RESERVED, LOST;
}

public enum BookFormat{
    HARDCOPY, PAPERBACK, NEWSPAPER, JOURNAL;
}

class Rack {
    int rackNumnber;
    String locationId;
}

class Person {
    String firstName;
    String lastNamr;
}

class Author extends Person {
    List<Book> booksPublished;
}

class SystemUsers extends Person {
    String email;
    String phoneNumber;
    Account account;
}

class Member extends SystemUsers {
    int totalBooksCheckout;
    Search searchObj;
    BookIssueService bookIssueService;
}

class Librarian extends SystemUsers {
    SearchObj searchobj;
    BookIssueService bookIssueService;
    public void addBook(Book book);
    public BookItem deleteBook(Book book);
    public BookItem editBook(Book book);
}

class Account {
    String username;
    String password;
    int accountId;
}

class Search {
    public List<BookItem> getBookByAuthor(Author author);
    public List<BookItem> getBookByTitle(String title);
    public List<BookItem> getBookByType(BookType bookType);
    public List<BookItem> getBookBypublicationDate(Date publicationDate);
}

class BookIssueService {
    FineService fineService;
    public BookReservationDetials getReservationDetails(BookItem book);
    public void updateReservationDetails(BookReservationDetials bookReservationDetials);
    public BookReservationDetials reserveBoook(BookItem book, SystemUsers user);
    public BookIssueDetails issueBook(BookItem book, SystemUsers user);
    public BookIssueDetails renewBook(BookItem book, SystemUsers user);
    public void returnBook(BookItem book, SystemUsers user);
}

class BookLendingDetails {
    BookItem Book;
    Date startDate;
    SystemUsers user;
}

class BookReservationDetials extends BookLendingDetails {
    ReservationStatus reservationStatus;
}

class BookIssueDetails extends BookLendingDetails {
    Date dueDate;
}

class FineService {
    public Fine calculateFine(BookItem book, SystemUsers user, int days);
}

class Fine {
    Date fineDate;
    BookItem book;
    SystemUsers user;
    Double fineValue;
}