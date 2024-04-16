import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO tblusers (name,email) VALUES (?,?)"
            )){
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            statement.setString(1,name);
            statement.setString(2,email);
            int rowsInserted = statement.executeUpdate();
            System.out.println("Rows inserted: "+rowsInserted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
