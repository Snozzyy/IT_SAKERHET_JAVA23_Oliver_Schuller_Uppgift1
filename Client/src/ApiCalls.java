import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCalls {

    static String baseUrl = "http://localhost:8080/";

    public static void loginRequest(String email,
                                    String password,
                                    String fName,
                                    String lName,
                                    String town,
                                    String address,
                                    String zip,
                                    String phoneNumber) {

        String requestUrl = baseUrl + String.format("/register?email=%s&password=%s&fname=%s&lname=%s&town=%s&address=%s&zip=%s&phone=%s", email, password, fName, lName, town, address, zip, phoneNumber);

    }

    public static void registerRequest(String email, String password, String fname, String lname, String phone, String address, String city, int zip) {

    }

    public static void getDetails(String email, String password) {

    }

    public static void deleteAccount(String email, String password) {

    }

    private static void sendRequest(String url) {
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
