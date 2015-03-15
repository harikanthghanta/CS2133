import java.io.*;
import java.security.AccessControlException;
import java.util.Scanner;

/**
 * Created by kyle on 3/3/15.
 *
 * Usage as follows `java Caesar -option key inFile outFile`
 */
public class Caesar {
    File inFile;
    File outFile;
    int key;

    public Caesar(File inFile, File outFile, int key){
        this.inFile = inFile;
        this.outFile = outFile;
        this.key = key;
    }

    public Caesar(){

    }

    public void encryptFile(){
        try{
            Scanner scanner = new Scanner(inFile);
            PrintWriter printWriter = new PrintWriter(outFile);


            while (scanner.hasNextLine()){
                String tempIn = scanner.nextLine();
                String tempEncrypt = encryptLine(tempIn, key);
                printWriter.write(tempEncrypt + "\n");
            }
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }

    public void decryptFile(){
        try{
            Scanner scanner = new Scanner(inFile);
            PrintWriter printWriter = new PrintWriter(outFile);


            while (scanner.hasNextLine()){
                String tempIn = scanner.nextLine();
                String tempDecrypt = decryptLine(tempIn, key);
                printWriter.write(tempDecrypt + "\n");
            }
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }

    public String encryptLine(String inLine, int key){
        String outLine = "";

        for(int i = 0; i < inLine.length(); i++){
            char tempChar = inLine.charAt(i);
            if (tempChar > 32 || tempChar < 126) tempChar = (char)tempChar;
            tempChar = (char)(tempChar + key);
            if (tempChar > 126) tempChar = (char)(tempChar - 95);
            if (tempChar < 32) tempChar = (char)(tempChar  + 95);
            outLine += tempChar;
        }

        return outLine;
    }

    public String decryptLine(String inLine, int key){
        String outLine = "";

        for(int i = 0; i < inLine.length(); i++){
            char tempChar = inLine.charAt(i);
            if (tempChar > 32 || tempChar < 126) tempChar = (char)tempChar;
            tempChar = (char)(tempChar - key);
            if (tempChar > 126) tempChar = (char)(tempChar - 95);
            if (tempChar < 32) tempChar = (char)(tempChar  + 95);
            outLine += tempChar;
        }

        return outLine;
    }

    public static void printError(){
        System.out.println("Proper Usage is: java Caesar [usage option] [key] [infile] [outfile]");
        System.out.println("Usage options: -d to decrypt, -e to encrypt");
        System.exit(0);
    }

    public static void main(String[] args) {
        File inFile;
        File outFile;
        int key;
        boolean isEncrypt = true;

        if(args.length != 4)
        {
            printError();
        }

        outFile = new File(args[3]);
        key = Integer.parseInt(args[1]);

        if(args[0].equals("-e")){
            isEncrypt = true;
        } else if (args[0].equals("-d")){
            isEncrypt = false;
        } else {
            printError();
        }

        try {
            inFile = new File("/home/kyle/JavaProjects/CS2133/Assignment4/Caesar/src/in.txt");
            if(!inFile.exists() && !inFile.isDirectory()){
                throw new FileNotFoundException();
            }
            Caesar caesar = new Caesar(inFile, outFile, key);
            if(isEncrypt){
                caesar.encryptFile();
            } else {
                caesar.decryptFile();
            }

        } catch (AccessControlException e){
            System.out.println("improper permissions for input or output file");
        } catch (FileNotFoundException e){
            System.out.println("input file doesn't exist");
        }
    }
}
