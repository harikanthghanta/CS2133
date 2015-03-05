import java.io.*;
import java.security.AccessControlException;
import java.util.Scanner;

/**
 * Created by kyle on 3/3/15.
 *
 * Usage as follows `java Caesar key infile [outfile]`
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

    public static void main(String[] args) {
        File inFile;
        File outFile;
        int key;

        if(args.length != 3)
        {
            System.out.println("Proper Usage is: java Caesar key infile [outfile]");
            System.exit(0);
        }

        outFile = new File(args[2]);
        key = Integer.parseInt(args[0]);

        try {
            inFile = new File("/home/kyle/JavaProjects/CS2133/Assignment4/Caesar/src/in.txt");
            if(!inFile.exists() && !inFile.isDirectory()){
                throw new FileNotFoundException();
            }
            Caesar caesar = new Caesar(inFile, outFile, key);
            caesar.encryptFile();
        } catch (AccessControlException e){
            System.out.println("improper permissions for input or output file");
        } catch (FileNotFoundException e){
            System.out.println("input file doesn't exist");
        }
    }
}
