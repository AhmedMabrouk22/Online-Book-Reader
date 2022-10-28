
package online.book.reader;
/**
 *
 * @author Ahmed Mabrouk
 */

import java.util.ArrayList;
import java.util.Scanner;


public class Customer extends User {
    private ArrayList<Book> myBooks = new ArrayList();
    private Book currentReadingBook;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    } // End constructor


    private Book searchBook() {
        if (Run.books.isEmpty()) {
            System.out.println("---> No exist books in system");
            return null;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("\tEnter book id: ");
        int id = in.nextInt();

        for (Book book : Run.books) {
            if (book.getBookId() == id)
                return book;
        }
        System.out.println("---> this book is not exist");
        return null;
    }

    public void setCurrentReadingBook(Book currentReadingBook) {
        this.currentReadingBook = currentReadingBook;
    }

    public Book getCurrentReadingBook() {
        return currentReadingBook;
    }

    public void listBooks() {
        if (Run.books.isEmpty()) {
            System.out.println("---> No exist books in system");
            return;
        }
        for (Book book : Run.books) {
            System.out.println("============================================");
            System.out.println("\tBook ID: " + book.getBookId());
            System.out.println("\tBook name: " + book.getName());
            System.out.println("\tBook author: " + book.getAuthor());
            System.out.println("\tNumber of pages: " + book.getNoPage());
            System.out.println("============================================");
        }

    } // End lsitBooks Method

    public void listBook(Book book) {
        if (book == null)
            System.out.println("you don't read and book");
        else {
            System.out.println("============================================");
            System.out.println("\tBook ID: " + book.getBookId());
            System.out.println("\tBook name: " + book.getName());
            System.out.println("\tBook author: " + book.getAuthor());
            System.out.println("\tNumber of pages: " + book.getNoPage());
            System.out.println("\tCurrent page: " + book.getCurrentPage());
            System.out.println("\tFinsh reading: " + ((book.getIsEnd() == true) ? "Yes" : "NO"));
            System.out.println("============================================");
        }

    }

    public void listMyBooks() {
        if (myBooks.isEmpty()) {
            System.out.println("---> you not added and read any book");
            return;
        }
        for (Book book : myBooks) {
            System.out.println("============================================");
            System.out.println("\tBook ID: " + book.getBookId());
            System.out.println("\tBook name: " + book.getName());
            System.out.println("\tBook author: " + book.getAuthor());
            System.out.println("\tNumber of pages: " + book.getNoPage());
            System.out.println("============================================");
        }

    } // End listMyBooks Method


    public void readBook() {
        Book book = searchBook();
        if (book != null)
            setCurrentReadingBook(book);
    } //End readBook Method

    public void addBookToMyList() {
        Book book = searchBook();
        if (book != null)
            myBooks.add(book);
    } //End addBookToMyList Method

    public void reading() {
        Book book = getCurrentReadingBook();
        if (book == null) {
            System.out.println("Please add book to your list");
            return;
        }
        System.out.println("Book name: " + book.getName());
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("page: " + book.getCurrentPage());
            System.out.println("press N to next page and P to previous page and Q to end");
            Scanner in = new Scanner(System.in);
            char ch = in.next().charAt(0);

            if (book.getCurrentPage() == book.getNoPage())
                book.setIsEnd();

            if (ch == 'N')
                book.nextPage();
            else if (ch == 'P')
                book.previousPage();
            else
                break;
        }

    }


}
