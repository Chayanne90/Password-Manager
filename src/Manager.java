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
        String randomeCharacter = "9536oplejkv@#$%";

        // This array type char is the same size of randomeCharacter
        char [] arr = new char[randomeCharacter.length()];

        for (int i = 0; i < 10; i++) {

            // Inserting char into arr
            arr[i] = randomeCharacter.charAt(r.nextInt(randomeCharacter.length()));
        }

        // Copying values if arr into pwd
        String pwd = String.copyValueOf(arr);
        this.password = pwd;
        return this.password;
    }

    /* Database Connection */
    private Connection connection() {

        String url = "jdbc:mysql://localhost:3306";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return conn;
    }
    
}
