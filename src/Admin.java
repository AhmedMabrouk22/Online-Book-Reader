
package online.book.reader;
/**
 *
 * @author Ahmed Mabrouk
 */
import java.util.Scanner;


public class Admin extends User{

    public Admin(){}
    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    } // End Constructor


    public Book addBook()
    {
        String name;
        String author;
        int noPage;

        Scanner in = new Scanner(System.in);

        System.out.print("\tEnter book name: ");
        name = in.nextLine();

        System.out.print("\tEnter book author: ");
        author = in.nextLine();

        while(true)
        {
            System.out.print("\tEnter book number of page: ");
            noPage = in.nextInt();
            if (noPage > 0)
                break;
            System.out.println("---> Invalid value ... try again");
        }

        //Book newBook =
        System.out.println("---> Book is add successfuly");
        return new Book(name,author,noPage);

    } // End addBook Method

}
