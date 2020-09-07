
/**
 * This implements an Enigma machine with 1 rotor
 * 
 * This project is implements the encryption system from
 * Nova: Decoding Nazi Secrets, Clasroom Activity at
 * https://www.pbs.org/wgbh/nova/teachers/activities/2615_decoding.html
 * 
 * @author Howard Francis
 * @version 2018.12.16
 */
public class MiniEnigma
{
    // instance variables - replace the example below with your own
    private CodeWheel rotor;

    /**
     * Constructor for objects of class MiniEnigma. It creates a single
     * code wheel which uses a caesar cipher.
     */
    public MiniEnigma()
    {
        rotor = new CodeWheel("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    /**
     * The primary method to encrypt a string
     * 
     * @param text          the message to be encrypted
     * @param startIndex    the starting position of the inner wheel r.w.t the outer wheel
     * @param shift         the amount to move the wheel after each letter
     */
    public String encrypt(String text, int startIndex, int shift)
    {
        int index = startIndex + 1;
        char newLetter;
        String encryptedText = "";
        for (int pos = 0; pos < text.length(); pos ++) {
            newLetter = rotor.use(text.charAt(pos), index, true);
            encryptedText += newLetter;
            if (Character.isLetter(newLetter)) {
                index = (index + shift - 1) % 26 + 1;
            }
        }
        return encryptedText;
    }
    
    public String decrypt(String text, int startIndex, int shift)
    {
        int index = startIndex + 1;
        char newLetter;
        String decryptedText = "";
        for (int pos = 0; pos < text.length(); pos ++) {
            newLetter = rotor.use(text.charAt(pos), index, false);
            decryptedText += newLetter;
            if (Character.isLetter(newLetter)) {
                index = (index + shift - 1) % 26 + 1;
            }
        }
        return decryptedText;
    }
}
