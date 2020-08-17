package passwordmanager;

import java.io.*;
import java.util.Scanner;

public class NormalUser extends User{

    public NormalUser(String username, String password){
        super(username, password);
    }

    public static void ViewVault(String username) throws IOException {

        String filePath = username + ".txt";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
        System.out.println("What would you like to do next");
        System.out.println("What would you like to do?\n1: View your passwords\n2: Add to your vault\n0: Exit");
    }

    public static void AddRecord(String username) throws IOException {
        String site;
        String newName;
        String newPass;

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the website: ");
        site = input.nextLine();
        System.out.println("Please enter the username: ");
        newName = input.nextLine();
        System.out.println("Please enter the password");
        newPass = input.nextLine();

        String filePath =  username + ".txt";
        FileWriter fw = new FileWriter(filePath, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println(site + "," + newName + "," + newPass);
        pw.flush();
        pw.close();

        System.out.println("Password added to vault");
        System.out.println("What would you like to do next");
        System.out.println("What would you like to do?\n1: View your passwords\n2: Add to your vault\n0: Exit");
    }
}

