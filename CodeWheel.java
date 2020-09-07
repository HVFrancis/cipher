
/**
 * This class implements a simple substitution cipher coder/decoder 
 * ring. The inner (actual) wheel can be rotated to any position (1 - 26) 
 * to create a different ordering of the letters
 * 
 * This project is implements the encryption system from
 * Nova: Decoding Nazi Secrets, Clasroom Activity at
 * https://www.pbs.org/wgbh/nova/teachers/activities/2615_decoding.html
 * 
 * 
 * @author Howard V Francis @version 0.1
 */
public class CodeWheel
{
    private String cipher = "GNBPWHQAJRITSCXUDKYLEZOVMF";

    /**
     * Default Constructor for objects of class CodeWheel Sets up 
     * GNBPWHQAJRITSCXUDKYLEZOVMF as the cipher string. This is used
     * in Part I of the NOVA activity
     */
    public CodeWheel()
    {
        /* Default constructor uses initializes version of cipher*/
    }

    /**
     * Constructor to provide the cipher string. The first letter in the string is mapped to A, 
     * 
     * the next to B, and so on. If the string is not 26 characters long, the default cipher string is used. There is no check that each letter in the string is different!
     * @param cipher    the 26-character cipher string to use.
     */
    public CodeWheel(String cipher)
    {
        if (cipher.length() == 26) {
            this.cipher = cipher;
        }
        /* else leave cipher as the default cipher string*/
    }

    /**
     * The use method is called to use the code wheel.
     * 
     * @param c         the letter to be encrypted/decrypted 
     * @param index     the rotation, if any, of the wheel. 1 = no rotation, 2 = rotated 1 right, etc 
     * @param encrypt   true of encoding, false if decoding
     * @returns the encypted/decrypted letter. If the first parameter is not a letter, it is simply returned back
     */
    public char use(char c, int index, boolean encrypt)
    {
        if ( ! Character.isLetter(c)) {
            return c;
        }
        int shift = index - 1;
        c = Character.toUpperCase(c);
        if (encrypt) {
            return encrypt(c, shift);
        }
        else {
            return decrypt(c, shift);
        }
    }

    /**
     * 
     */
    private char encrypt(char c, int shift)
    {
        int location = Character.getNumericValue(c) - Character.getNumericValue('A');
        location = (location + shift) % 26;
        char newLet = cipher.charAt(location);
        return newLet;
    }

    /**
     * 
     */
    private char decrypt(char c, int shift)
    {
        int location = cipher.indexOf(c);
        location = (location + 26 - shift) % 26;
        int newLocation = location + 65;
        char newLetter = Character.toString((char)newLocation).charAt(0);
        return newLetter;
    }
}
