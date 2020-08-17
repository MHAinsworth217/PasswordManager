package passwordmanager;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdminUser extends User {

    Scanner input = new Scanner(System.in);

    public AdminUser(String username, String password) {
        super(username, password);
    }

    public void SeePasswords() throws IOException {

        Authenticator auth = new Authenticator();
        System.out.println("The users that you can access are: ");

        List<String> list = Arrays.asList(auth.users);

        while (true) {
            for (String name : auth.users) {
                System.out.println(name);
            }
            String choice = input.nextLine();
            System.out.println(choice);
            if (list.contains(choice)) {
                String filePath = choice + ".txt";
                File file = new File(filePath);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null) {
                    System.out.println(st);
                }
                System.out.println("Would you like to see anything else? y/n");
                String yn = input.nextLine();
                if (yn.equals("y"))
                    System.out.println("Who would you like to see?");
                else if (yn.equals("n")) {
                    System.out.print("Goodbye!");
                    System.exit(0);
                } else
                    System.out.println("Please enter 'y' or 'n'");
            } else
                System.out.println("Please select a valid option.");
        }
    }
}
