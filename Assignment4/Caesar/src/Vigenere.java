import java.io.File;

/**
 * Created by kyle on 3/3/15.
 *
 * usage as follows `java Vigenere -option key inFile outFile`
 */
public class Vigenere {
    File inFile;
    File outFile;
    String key;

    public Vigenere(File inFile, File outFile, String key){
        this.inFile = inFile;
        this.outFile = outFile;
        this.key = key;
    }

    public Vigenere(){}



    /**
     * Method that takes a line of text as a String and returns the encrypted value.
     * Encryption is done using the Vigenere cypher.
     * ASCII characters are shifted by the int value of the key.
     *
     * @param inLine the input line to be encrypted
     * @param key the string key used for the value of the key
     * @return outLine the value of the encypted line
     */
    public String encryptLine(String inLine, String key){
        String outLine = "";
        int keyCharIndex = 0;

        for(int i = 0; i < inLine.length(); i++){
            char lineChar = inLine.charAt(i);
            char keyChar = key.charAt(keyCharIndex);

            if (lineChar > 32 || lineChar < 126) lineChar = (char)lineChar;

            lineChar = (char)(lineChar + keyChar);

            if (lineChar > 126) lineChar = (char)(lineChar - 95);

            if (lineChar < 32) lineChar = (char)(lineChar  + 95);

            System.out.println((int)lineChar + " shift result of " + inLine.charAt(i) + " + " + keyChar);

            keyCharIndex++;
            if (keyCharIndex == key.length()) keyCharIndex = 0;

            outLine += lineChar;
            System.out.println("E: " + outLine);
        }

        return outLine;
    }

    public String decryptLine(String inLine, String key){
        String outLine = "";
        int keyCharIndex = 0;

        for(int i = 0; i < inLine.length(); i++){
            char tempChar = inLine.charAt(i);
            char keyChar = key.charAt(keyCharIndex);

            System.out.println((int)tempChar);

            if (tempChar > 32 || tempChar < 126) tempChar = (char)tempChar;

            //System had problems with negative values after subtracting the key
            //this if statement prevents Java from converting the char to unicode and throwing off the value check
            if (tempChar - keyChar < 0){
                tempChar = (char)(tempChar - keyChar + 95);
            } else {
                tempChar = (char)(tempChar - keyChar);
            }


            if (tempChar > 126) tempChar = (char)(tempChar - 95);

            if (tempChar < 32) tempChar = (char)(tempChar  + 95);

            System.out.println((int)tempChar + " shift result of " + inLine.charAt(i) + " - " + keyChar);

            keyCharIndex++;
            if (keyCharIndex == key.length()) keyCharIndex = 0;

            outLine += tempChar;
            System.out.println("D: " + outLine);
        }

        for (int i = 0; i < outLine.length(); i++){
            System.out.print(outLine.charAt(i));
        }
        System.out.println();

        for (int i = 0; i < outLine.length(); i++){
            System.out.print((int)outLine.charAt(i) + " ");
        }
        System.out.println();
        return outLine;
    }

    public static void printError(){
        System.out.println("Propper Usage is: java Vigenere -option key inFile outFile");
        System.out.println("Usage option: -d to decrypt, -e to encrypt");
        System.exit(0);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
