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
        this.inFile = new File("/home/kyle/JavaProjects/CS2133/Assignment4/Caesar/src/in.txt");
        this.outFile = new File("/home/kyle/JavaProjects/CS2133/Assignment4/Caesar/src/out.txt");
        this.key = 3;
    }

    public void caesarShift(){
        try{
            //Runtime.getRuntime().exec("chmod 777 " + "/home/kyle/JavaProjects/CS2133/Assignment4/Caesar/src/out.txt");

            //FilePermission outPermission = new FilePermission("/home/kyle/JavaProjects/CS2133/Assignment4/Caesar/src/out.txt", "write");

            //AccessController.checkPermission(outPermission);

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
        } catch (AccessControlException e){
            System.out.println("insufficient permissions");
        } catch (IOException e){
            System.out.println("could not set permissions");
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
        Caesar caesar = new Caesar();
        caesar.caesarShift();

        /*
        File inFile;
        File outFile;
        int key;

        if(args.length != 3)
        {
            System.out.println("Proper Usage is: java Caesar key infile [outfile]");
            System.exit(0);
        }

        //outFile = new File(args[2]);
        outFile = new File("/home/kyle/JavaProjects/CS2133/Assignment4/Caesar/src/out.txt");
        key = Integer.parseInt(args[0]);

        try {
            //inFile = new File(args[1]);
            inFile = new File("/home/kyle/JavaProjects/CS2133/Assignment4/Caesar/src/in.txt");
            if(!inFile.exists() && !inFile.isDirectory()){
                throw new FileNotFoundException();
            }

            //check file permissions
            FilePermission inPermission = new FilePermission(args[1], "read");
            FilePermission outPermission = new FilePermission(args[2], "write");

            AccessController.checkPermission(inPermission);
            AccessController.checkPermission(outPermission);

            Caesar caesar = new Caesar(inFile, outFile, key);
            caesar.caesarShift();
        } catch (AccessControlException e){
            System.out.println("improper permissions for input or output file");
        } catch (FileNotFoundException e){
            System.out.println("input file doesn't exist");
        }
        */
    }
}
