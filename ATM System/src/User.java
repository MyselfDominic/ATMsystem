import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinHash[]; //The MD5 hash of the user's pin number

    private ArrayList<Account> accounts; //The list of accounts for this user

    public User(String firstName, String lastName, String pin, Bank theBank) {
        this.firstName = firstName;
        this.lastName = lastName;

        //store the pin's MDS hash,rather than the original value,for
        //security.
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error, caught. NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        //get a new, uuid for the user
        this.uuid =  theBank.getNewUserUUID();


    }



}
