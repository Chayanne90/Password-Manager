import java.util.Random;

public class Manager {

    /*Instance Variables*/
    private String emaill;
    private String description;
    private String password;



    /* Methods */
    public String generatePassword() {                                          // This method return a randome password.
        
        Random r = new Random();
        String randomeCharacter = "9536oplejkv@#$%";

        /* This array type char is the same size of randomeCharacter*/
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
