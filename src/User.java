
package online.book.reader;
/**
 *
 * @author Ahmed Mabrouk
 */

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean is_admin;



    public User(){}
    public User(String firstName, String lastName, String email, String password)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);

    } // End Constructor


    // Getter and Setter

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean setEmail(String email) {
        if (Run.checkEmail(email))
        {
            System.out.println("This email is alreddy exist");
            return false;
        }

        this.email = email;
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIs_admin() {
        this.is_admin = true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return is_admin;
    }

    public void viewProfile()
    {
        System.out.println("\tProfile Page: ");
        System.out.print("\tNema: ");
        System.out.println(getFirstName() + " " + getLastName());

    } // End viewProfile function


    public User logIn()
    {
        String email;
        String password;
        Scanner in = new Scanner(System.in);

        while(true)
        {
            System.out.print("\tEnter Email: ");
            email = in.next();
            System.out.print("\tEnter Password: ");
            password = in.next();
            if (Run.users.containsKey(email)
                    && Run.users.get(email).getPassword().equals(password))
                break;
            System.out.println("---> Sorry Email or Passower incorect .. try again");
        }


        return Run.users.get(email);

    } // End Login function


    public void logOut()
    {
        Run.menu(); // call Function menu in Run Class to go to main menu in system
    } // End logOut function


    public User singUp()
    {

        String firstName;
        String lastName;
        String email;
        String password;
        Scanner in = new Scanner(System.in);
        System.out.print("\tEnter first name: ");
        firstName = in.next();

        System.out.print("\tEnter last name: ");
        lastName = in.next();

        while(true)
        {
            System.out.print("\tEnter email: ");
            email= in.next();
            if (!Run.checkEmail(email))
                break;
            else
                System.out.println("---> This email is alreddy exist");
        }

        while(true)
        {
            System.out.print("\tEnter Password: ");
            password = in.next();
            if (password.length() >= 8)
                break;
            System.out.println("---> Password length must be grater than 8");
        }

        Customer newUser = new Customer(firstName, lastName, email, password);
        Run.users.put(email, newUser);
        System.out.println("---> Sing up is ok\n");
        return newUser;
    } // End SingUp Method


    // End addBook Method



}
