import java.util.Scanner;

public class Cli {
    static Scanner sc = new Scanner(System.in);

    private static void login() {
        System.out.print("Enter your email: ");
        String email = sc.next();
        System.out.print("Enter you password: ");
        String password = sc.next();

        System.out.println(email + password);
    }

    private static void register() {
        System.out.println("reg");
    }

    public static void menu() {
        boolean runMenu = true;

        while (runMenu) {
            System.out.println("--------------------");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    runMenu = false;
            }
        }

    }

}
