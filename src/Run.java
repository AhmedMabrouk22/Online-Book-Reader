
package online.book.reader;
/**
 *
 * @author Ahmed Mabrouk
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Run {


    // all users in system
    public static Map<String,User> users= new HashMap();

    // books in system
    public static ArrayList<Book> books = new ArrayList();


    // Check if this user is exist in system or not
    public static boolean checkEmail(String email)
    {
        return users.containsKey(email);
    } // End checkEmail Method

    // Create admin for System

    private static void createAdmin()
    {
        User admin = new Admin("admin","","admin@admin.com","admin");
        admin.setIs_admin();
        users.put("admin@admin.com",admin);

    } // End createAdmin Method


    /*
        Show function:
        show all choices in menu
    */
    private static int show(ArrayList<String> menu)
    {
        for (int i = 0 ; i < (int)menu.size() ;++i)
            System.out.printf("\t%d: %s %n",i+1,menu.get(i));

        Scanner in = new Scanner(System.in);
        int num=0;
        System.out.print("Enter number in range 1 - " + menu.size() + " : ");
        try {
            num = in.nextInt();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (num < 1 || num > menu.size())
        {
            System.out.println("--> Invalid number ... try again");
            System.out.println("==================================");
            return show(menu);
        }
        return num;
    } // End show Method


    // show log in and singup operation and return user that use this system
    public static User LoginAndSingUpMenu()
    {
        User user = new User();
        int ch = show(new ArrayList(Arrays.asList("Login","Sing Up")));
        if (ch == 1)
        {
            System.out.println("===========================================");
            System.out.println("Login Section \n");
            return user.logIn();

        }
        else if (ch == 2)
        {
            System.out.println("===========================================");
            System.out.println("SingUp Section \n");
            return user.singUp();

        }

        return null;
    } // End LoginAndSingUpMenu Method


    // Operation for Customer
    public static void operationMenu(Customer user)
    {
        ArrayList<String> operation = new ArrayList();
        operation.add("List system books");
        operation.add("List my books");
        operation.add("View current reading book");
        operation.add("Add book to my list");
        operation.add("Read book");
        operation.add("View profile");
        operation.add("Reading session");
        operation.add("Logout");
        int ch = show(operation);

        if (ch == 1)
            user.listBooks();
        else if(ch == 2)
            user.listMyBooks();
        else if (ch == 3)
            user.listBook(user.getCurrentReadingBook());
        else if (ch == 4)
            user.addBookToMyList();
        else if (ch == 5)
            user.readBook();
        else if (ch == 6)
            user.viewProfile();
        else if (ch == 7)
            user.reading();
        else if (ch == 8)
            user.logOut();

        System.out.println("===========================================");
        operationMenu(user);
    }

    // Operation for admin
    public static void operationMenu(Admin admin)
    {

        int ch = show(new ArrayList(Arrays.asList("add book","Logout")));
        if (ch ==1)
            books.add(admin.addBook());
            //it recive Book object from add book method and add it to arraylist
        else if (ch == 2)
        {
            admin.logOut();
            return;
        }

        System.out.println("===========================================");
        operationMenu(admin);
    }


    public static void menu()
    {
        System.out.println("\nMenu: ");
        User user = LoginAndSingUpMenu();
        System.out.println("===========================================");
        System.out.println("Welcome :" + user.getFirstName());
        if (user.isAdmin())
            operationMenu((Admin)user);
        else
            operationMenu((Customer)user);

    } // End menu Method


    public static void run()
    {
        createAdmin();
        System.out.println("\t\t Welcome to Online Book Reader");
        System.out.println("\t\t\t (Ahmed Mabrouk)");
        System.out.println("\t==============================================");
        menu();
    } // End go Method

}
