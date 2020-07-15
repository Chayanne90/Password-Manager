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
        String randomCharacter = "9536oplejkv@#$%";

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
    private Connection connection() {                                           /* return object type connection */

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


    public int insertAccount(String accountDescription) {                        /* return 1 when an account is inserted in the database  */

        String sql = "INSERT INTO Accounts (description, date)" + "VALUES (?, datetime('now'))";

        int resultQuery = 0;

        try (Connection connection = this.connection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, accountDescription);

            // pstmt.executeUpdate() -
            resultQuery = pstmt.executeUpdate();
            connection.close();

            System.out.println("Data Inserted...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultQuery;
    }

    public String getAccounts(String description) {

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

    public void insertCredentials(int acc_id, String email, String password) {



    }

}
