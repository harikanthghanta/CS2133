import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.AccessControlException;
import java.util.Scanner;

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

    public void encryptFile(){
        try {
            Scanner scanner = new Scanner(inFile);
            PrintWriter printWriter = new PrintWriter(outFile);

            while (scanner.hasNextLine()){
                String tempIn = scanner.nextLine();
                String tempEncrypt = encryptLine(tempIn, key);
                printWriter.write(tempEncrypt + "\n");
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        }
    }

    public void decryptFile(){
        try {
            Scanner scanner = new Scanner(inFile);
            PrintWriter printWriter = new PrintWriter(outFile);

            while (scanner.hasNextLine()){
                String tempIn = scanner.nextLine();
                String tempDecrypt = decryptLine(tempIn, key);
                printWriter.write(tempDecrypt + "\n");
            }
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        }
    }

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

            keyCharIndex++;
            if (keyCharIndex == key.length()) keyCharIndex = 0;

            outLine += lineChar;
        }

        return outLine;
    }

    public String decryptLine(String inLine, String key){
        String outLine = "";
        int keyCharIndex = 0;

        for(int i = 0; i < inLine.length(); i++){
            char tempChar = inLine.charAt(i);
            char keyChar = key.charAt(keyCharIndex);

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

            keyCharIndex++;
            if (keyCharIndex == key.length()) keyCharIndex = 0;

            outLine += tempChar;
        }

        return outLine;
    }

    public static void printError(){
        System.out.println("Propper Usage is: java Vigenere -option key inFile outFile");
        System.out.println("Usage option: -d to decrypt, -e to encrypt");
        System.exit(0);
    }

    public static void main(String[] args) {
        File inFile;
        File outFile;
        String key;
        boolean isEncrypt = true;

        if (args.length != 4){
            printError();
        }

        outFile = new File(args[3]);
        key = args[1];

        if(args[0].equals("-e")){
            isEncrypt = true;
        } else if (args[0].equals("-d")){
            isEncrypt = false;
        } else {
            printError();
        }

        try {
            inFile = new File(args[2]);
            if(!inFile.exists() && !inFile.isDirectory()){
                throw new FileNotFoundException();
            }
            Vigenere vigenere = new Vigenere(inFile, outFile, key);
            if(isEncrypt){
                vigenere.encryptFile();
            } else {
                vigenere.decryptFile();
            }
        } catch (AccessControlException e){
            System.out.println("impropper permissions for input or output file");
        } catch (FileNotFoundException e) {
            System.out.println("input file does not exist");
        }
    }
}
