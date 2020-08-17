package passwordmanager;

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class passwordManager {

    public static void main(String[] args) throws IOException {
        Authenticator authenticator = new Authenticator();

        Scanner input = new Scanner(System.in);

        String username;
        String password;

        System.out.println("Welcome to Matt's Password Manager.");
        System.out.print("Please enter your username: ");
        username = input.nextLine();

        System.out.print("Please enter your password: ");
        password = input.nextLine();

        final User login = new User(username, password);

        if (authenticator.checkPass(login)) {
            System.out.println("You are logged in!");
            if (!authenticator.accountAdmin) {
                System.out.println("Logged in as: " + username);
                System.out.println("What would you like to do?\n1: View your passwords\n2: Add to your vault\n0: Exit");
                int choice;
                while (true) {
                    try {
                        choice = input.nextInt();
                        if ((choice == 0) || (choice == 1) || (choice == 2))
                            switch (choice) {
                                case 1:
                                    NormalUser.ViewVault(username);
                                    break;
                                case 2:
                                    NormalUser.AddRecord(username);
                                    break;
                                case 0:
                                    System.out.println("Goodbye");
                                    System.exit(0);
                            }
                        else
                            System.out.println("Please enter a valid option");

                    } catch (InputMismatchException e) {
                        System.out.println("Sorry, I didn't understand. Please enter an integer from the options.");
                        input.next();
                        continue;
                    }
                }
            } else if (authenticator.accountAdmin) {
                System.out.println("Logged in as admin user: " + username);
                AdminUser admin = new AdminUser(username, password);
                admin.SeePasswords();
            }
        } else
            System.out.println("Username or password is incorrect.");
    }
}