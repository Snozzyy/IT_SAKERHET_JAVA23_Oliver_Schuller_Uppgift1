package org.example;

import org.json.JSONObject;

import java.util.Scanner;

public class Cli {
    private static final Scanner sc = new Scanner(System.in);
    private static boolean isLoggedIn = false;
    private static boolean runMenu = true;
    private static String email;
    private static String password;


    public static void menu() {
        while (runMenu) {
            if (!isLoggedIn) {
                loggedOutMenu();
            } else {
                loggedInMenu();
            }
        }
    }

    private static boolean login() {
        System.out.print("Enter your email: ");
        email = sc.next();
        System.out.print("Enter you password: ");
        password = sc.next();

        return ApiCalls.loginRequest(email, password);
    }



    private static void register() {
        System.out.print("Enter your email: ");
        String email = sc.next();
        System.out.print("Enter you password: ");
        String password = sc.next();
        System.out.print("Enter your first name: ");
        String fName = sc.next();
        System.out.print("Enter your last name: ");
        String lName = sc.next();
        System.out.print("Enter your town: ");
        String town = sc.next();
        System.out.print("Enter your address: ");
        String address = sc.next();
        System.out.print("Enter your zip (must be int): ");
        String zip = sc.next();
        System.out.print("Enter your phone number: ");
        String phoneNumber = sc.next();

        ApiCalls.registerRequest(email, password, fName, lName, town, address, zip, phoneNumber);
    }

    private static void getDetails() {
        String jsonResponse = ApiCalls.getDetails(email, password);
        if (!jsonResponse.isEmpty()) {
            try {
                JSONObject jsonObject = new JSONObject(jsonResponse);
                String email = jsonObject.getString("email");
                String fName = jsonObject.getString("fname");
                String lName = jsonObject.getString("lname");
                String town = jsonObject.getString("town");
                String address = jsonObject.getString("address");
                String zip = jsonObject.getString("zipCode");
                String phoneNumber = jsonObject.getString("phoneNumber");

                System.out.println("--------------------");
                System.out.println("Name: " + fName + " " + lName);
                System.out.println("Email: " + email);
                System.out.println("Town: " + town);
                System.out.println("Address: " + address);
                System.out.println("Zip code: " + zip);
                System.out.println("Phone number: " + phoneNumber);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void deleteAccount() {
        System.out.print("Are you sure you want to delete your account? Y/N: ");
        String answer = sc.next();

        if (answer.equalsIgnoreCase("y")) {
            ApiCalls.deleteAccount(email, password);
            System.out.println("\nAccount deleted");
            isLoggedIn = false;
            email = "";
            password = "";

        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("\nAccount not deleted");
        } else {
            System.out.print("Invalid input, please enter Y/N: ");
            deleteAccount();
        }
    }

    private static void loggedInMenu() {

        System.out.println("--------------------");
        System.out.println("1. Get details");
        System.out.println("2. Delete account");
        System.out.println("3. Log out");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                getDetails();
                break;
            case 2:
                deleteAccount();
                break;
            case 3:
                email = "";
                password = "";
                isLoggedIn = false;
        }
    }

    private static void loggedOutMenu() {
        System.out.println("--------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                isLoggedIn = login();
                break;
            case 2:
                register();
                break;
            case 3:
                runMenu = false;
        }
    }
}
