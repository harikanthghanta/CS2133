/**
 * Created by kyle on 3/15/15.
 */
public class VigenereTest {
    public static void decryptValueTest(){
        Vigenere vigenere = new Vigenere();

        String testString = "TEST line";
        String key = "Java";
        String testEncrypt = vigenere.encryptLine(testString, key);
        String testDecrypt = vigenere.decryptLine(testEncrypt, key);

        if(testDecrypt.equals(testString)){
            System.out.println("Decrypt Value Test: passed");
        } else {
            System.out.println("Decrypt Value Test: failed");
            System.out.println(testDecrypt + " != " + testString);
        }
    }

    public static void main(String[] args){
        decryptValueTest();

        System.out.println(((int)'T' + 'J' - 95) + " " + (int)'?');
        System.out.println((int)'?' + " " + ((int)'?' - 'J' + 95));
    }
}
