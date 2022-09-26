package co.develhope;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SQLSelect {

    public static void main(String[] args) {

        final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
        final String USER = "root";
        final String PASSWORD = "123";

        Connection connecton = null;

        ArrayList<String> surnames = new ArrayList<>();

        try {
            connecton = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connect to the database \n ");

            Statement statement = connecton.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM students");
            System.out.println("Printing Student surnames");

            while(result.next()) {
                surnames.add(result.getString("last-name"));

            }
            System.out.println(Arrays.toString(surnames.toArray()) + "\n ");

        }

        catch (Exception e) {
            e.printStackTrace();

        }
    }
}
