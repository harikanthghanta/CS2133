/**
 * Created by kyle on 3/3/15.
 */
public class CaesarTest {
    public static void decryptValueTest(){
        Caesar caesar = new Caesar();

        String testString = "Test Line";
        String testEncrypt = caesar.encryptLine(testString, 3);
        String testDecrypt = caesar.decryptLine(testEncrypt, 3);

        if(testDecrypt.equals(testString)){
            System.out.println("Decrypt Value Test: passed");
        } else {
            System.out.println("Decrypt Value Test: failed");
        }
    }

    public static void noInputTest(){
        String[] args = {"test"};
        System.out.println("\nTest of main with from args: ");
        Caesar.main(args);
    }

    public static void fileNotFoundTest(){

    }

    public static void filePermissionTest(){

    }

    public static void main(String[] args){
        decryptValueTest();
        noInputTest();
        fileNotFoundTest();
        filePermissionTest();
    }
}
