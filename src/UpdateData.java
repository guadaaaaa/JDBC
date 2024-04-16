import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "UPDATE tblusers SET name = ? WHERE id = ? RETURNING *"
             )){
            System.out.print("Enter new name: ");
            String newname = sc.nextLine();
            System.out.print("Enter id: ");
            int id = sc.nextInt();
            statement.setString(1,newname);
            statement.setInt(2,id);
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Rows updated: "+rowsUpdated);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
