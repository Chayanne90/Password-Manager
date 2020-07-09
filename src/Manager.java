import java.util.Random;

public class Manager {

    /*Instance Variables*/
    private String emaill;
    private String description;
    private String password;

    /* Getters and Setters*/
    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /* Methods */
    public String generatePassword() {                                          /* This method return a randome password */

        Random r = new Random();
        String randomeCharacter = "9536oplejkv@#$%";

        // This array type char is the same size of randomeCharacter
        char [] arr = new char[randomeCharacter.length()];

        for (int i = 0; i < 10; i++) {

            // Inserting char into arr
            arr[i] = randomeCharacter.charAt(r.nextInt(randomeCharacter.length()));
        }

        // Copying values if arr into pwd.
        String pwd = String.copyValueOf(arr);
        this.password = pwd;
        return this.password;
    }






}
