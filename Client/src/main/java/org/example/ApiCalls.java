package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class ApiCalls {

    static String baseUrl = "http://localhost:8080";

    public static void registerRequest(String email,
                                    String password,
                                    String fName,
                                    String lName,
                                    String town,
                                    String address,
                                    String zip,
                                    String phoneNumber) {

        String requestUrl = baseUrl + String.format("/register?email=%s&password=%s&fname=%s&lname=%s&town=%s&address=%s&zip-code=%s&phone-number=%s", email, password, fName, lName, town, address, zip, phoneNumber);
        sendRequest(requestUrl, "POST");

    }

    public static boolean loginRequest(String email, String password) {
        String requestUrl = baseUrl + String.format("/login?email=%s&password=%s", email, password);
        String response = sendRequest(requestUrl, "GET");

        if (!response.equals("null")) {
            return true;
        } else {
            return false;
        }
    }

    public static String getDetails(String email, String password) {
        String requestUrl = baseUrl + String.format("/my-details?email=%s&password=%s", email, password);

        return sendRequest(requestUrl, "GET");
    }

    public static void deleteAccount(String email, String password) {
        String requestUrl = baseUrl + String.format("/delete?email=%s&password=%s", email, password);
        sendRequest(requestUrl, "DELETE");
    }

    private static String sendRequest(String url, String method) {
        StringBuilder response = new StringBuilder();

        try {
            URL requestUrl = URI.create(url).toURL();
            HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();
            con.setRequestMethod(method);
            int responseCode = con.getResponseCode();

            if (responseCode >= 200 && responseCode < 300) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.err.println("Request failed with response code: " + responseCode);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return response.toString();
    }

}
