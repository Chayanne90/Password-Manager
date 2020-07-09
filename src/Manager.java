import java.util.Random;

public class Manager {

    /*Instance Variables*/
    private String emaill;
    private String description;
    private String password;



    /* Methods*/
    public String generatePassword() {
        
        Random r = new Random();
        String alphabet = "1295xyzrgb";

        for (int i = 0; i < 10; i++) {

            System.out.print(alphabet.charAt(r.nextInt(alphabet.length())));
        }
    }
}
