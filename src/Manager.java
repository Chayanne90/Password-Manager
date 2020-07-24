import java.sql.*;
import java.util.Random;

public class Manager {

    /* Instance Variables */
    private String email;
    private String description;
    private String password;

    /* Getters and Setters */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /* Methods */
    public String generatePassword() {                                          /* This method return a random password */

        Random r = new Random();
        String randomCharacter = "95#apile$%";

        // This array type char is the same size of randomeCharacter
        char [] arr = new char[randomCharacter.length()];

        for (int i = 0; i < 10; i++) {

            // Inserting char into arr
            arr[i] = randomCharacter.charAt(r.nextInt(randomCharacter.length()));
        }

        // Copying values from arr into pwd variable
        String pwd = String.copyValueOf(arr);
        this.password = pwd;
        return this.password;
    }

    /* Database Connection */
    private Connection connection() {                                            /* return object type connection */

        String url = "jdbc:sqlite:password_manager.db";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
            //System.out.println(" Connected to Database...");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return conn;
    }


    public int insertAccount(String accountDescription) {                         /* Insert the account into the database and return 1 when successfully inserted  */

        String sql = "INSERT INTO Accounts (description, date)" + "VALUES (?, datetime('now'))";
        int resultQuery = 0;

        try (Connection connection = this.connection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, accountDescription);
            resultQuery = pstmt.executeUpdate();
            connection.close();

            System.out.println("Data Inserted...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultQuery;
    }

    public String getAccounts(String description) {                                /* return the id and description of the account */

        String sql = "SELECT acc_id, description FROM Accounts WHERE description = ?";
        ResultSet st;
        String id = null;
        String descript;

        try (Connection connection = this.connection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, description);
            st = pstmt.executeQuery();

            while (st.next()) {
                id = st.getString("acc_id");
                //descript = st.getString("description");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    public void insertCredentials(String acc_id, String email, String password) {     /* Insert the credentials of teh account into the database */

        String sql = "INSERT INTO Credentials (acc_id, email, password, date) VALUES(?,?,?, datetime('now'))";

        try (Connection connection = this.connection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, acc_id);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            connection.close();
            System.out.println("Account Credentials Inserted...");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
